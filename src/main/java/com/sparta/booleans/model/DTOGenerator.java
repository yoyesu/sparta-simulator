package com.sparta.booleans.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import com.sparta.booleans.model.Client.Client;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainingCentre.Bootcamp;
import com.sparta.booleans.model.trainingCentre.Hub;
import com.sparta.booleans.model.trainingCentre.TechCentre;
import com.sparta.booleans.model.trainingCentre.TrainingCentre;

public class DTOGenerator {

    public static MappedDTO generateDTO(int month, ArrayList<Trainee> waitingList, ArrayList<Trainee> benchedList
                                        , ArrayList<TrainingCentre> trainingCentres, ArrayList<Client> clients) {

        HashMap<CourseType, Integer> traineesWaiting = new HashMap<>();
        HashMap<CourseType, Integer> traineesTraining = new HashMap<>();
        HashMap<CourseType, Integer> traineesOnBench = new HashMap<>();
        HashMap<CourseType, Integer> traineesWithClient = new HashMap<>();

        HashMap<TrainingCentreType, Integer> openCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> closedCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> fullCentres = new HashMap<>();

        for (CourseType type: CourseType.values()) {
            traineesWaiting.put(type, 0);
            traineesTraining.put(type, 0);
            traineesOnBench.put(type, 0);
            traineesWithClient.put(type, 0);
        }
        for (TrainingCentreType type: TrainingCentreType.values()) {
            openCentres.put(type, 0);
            closedCentres.put(type, 0);
            fullCentres.put(type, 0);
        }

        getTraineeCountByCourse(waitingList, traineesWaiting);
        getTraineesTraining(trainingCentres, traineesTraining);
        getTraineeCountByCourse(benchedList, traineesOnBench);
        getTraineesWithClient(clients, traineesWithClient);
        getCentreCountByType(trainingCentres, openCentres, closedCentres, fullCentres);
        int unhappyClients = getUnhappyClients(clients);
        int happyClients = clients.size() - unhappyClients;

        return new MappedDTO(month, traineesWaiting, traineesTraining,
                traineesOnBench, traineesWithClient, openCentres, closedCentres,
                fullCentres, happyClients, unhappyClients);
    }

    private static void getCentreCountByType(ArrayList<TrainingCentre> trainingCentres, HashMap<TrainingCentreType,
            Integer> openCentres, HashMap<TrainingCentreType, Integer> closedCentres, HashMap<TrainingCentreType,
            Integer> fullCentres) {
        for (TrainingCentre centre: trainingCentres) {
            TrainingCentreType type;
            if (centre instanceof TechCentre) {
                type = TrainingCentreType.TECH_CENTRE;
            } else if (centre instanceof Bootcamp) {
                type = TrainingCentreType.BOOTCAMP;
            } else if (centre instanceof Hub) {
                type = TrainingCentreType.TRAINING_HUB;
            } else {
                type = null;
            }

            incrementHashMap(openCentres, type);
            if (centre.isFull()) {
                incrementHashMap(fullCentres, type);
            }
            if (centre.getIsClosed()) {
                incrementHashMap(closedCentres, type);
            }
        }
    }

    private static void getTraineeCountByCourse(ArrayList<Trainee> trainees,
                                                HashMap<CourseType, Integer> traineeMap) {
        for (CourseType course: CourseType.values()) {
            long traineeCount = trainees.stream()
                    .filter(e -> e.getCourseType() == course)
                    .count();
            traineeMap.put(course, (int) traineeCount);
        }
    }

    private static void getTraineesTraining(ArrayList<TrainingCentre> trainingCentres,
                                            HashMap<CourseType, Integer> traineeMap) {
        ArrayList<Trainee> trainees = new ArrayList<>();

        for (TrainingCentre centre: trainingCentres) {
            trainees.addAll(centre.getCurrentTrainees());
        }

        getTraineeCountByCourse(trainees, traineeMap);
    }

    private static void getTraineesWithClient(ArrayList<Client> clients, HashMap<CourseType, Integer> clientMap) {
        ArrayList<Trainee> trainees = new ArrayList<>();

        for (Client client: clients) {
            for (Trainee t: client.getTraineesAssigned()) {
                //System.out.println(t);
                //System.out.println(t != null? t.getTraineeId() : null);
            }
            trainees.addAll(client.getTraineesAssigned());
        }

        getTraineeCountByCourse(trainees, clientMap);
    }

    private static void incrementHashMap(HashMap<TrainingCentreType, Integer> hasMap, TrainingCentreType type) {
        Integer amount = hasMap.get(type);
        hasMap.put(type, ++amount);
    }

    private static int getUnhappyClients(ArrayList<Client> clients) {
        int unhappyClients = 0;
        for (Client client: clients) {
            if (!client.isActive()) {
                unhappyClients++;
            }
        }
        return unhappyClients;
    }
}
