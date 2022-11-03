package com.sparta.booleans.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainingCentre.Bootcamp;
import com.sparta.booleans.model.trainingCentre.Hub;
import com.sparta.booleans.model.trainingCentre.TechCentre;
import com.sparta.booleans.model.trainingCentre.TrainingCentre;

public class DTOGenerator {

    public static MappedDTO generateDTO(int month, ArrayList<Trainee> waitingList, ArrayList<TrainingCentre> trainingCentres) {

        HashMap<CourseType, Integer> traineesWaiting = new HashMap<>();
        HashMap<CourseType, Integer> traineesTraining = new HashMap<>();

        HashMap<TrainingCentreType, Integer> openCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> closedCentres = new HashMap<>();
        HashMap<TrainingCentreType, Integer> fullCentres = new HashMap<>();

        for (CourseType type: CourseType.values()) {
            traineesWaiting.put(type, 0);
            traineesTraining.put(type, 0);
        }
        for (TrainingCentreType type: TrainingCentreType.values()) {
            openCentres.put(type, 0);
            closedCentres.put(type, 0);
            fullCentres.put(type, 0);
        }

        getTraineeCountByCourse(waitingList, traineesWaiting);
        getTraineesTraining(trainingCentres, traineesTraining);
        getCentreCountByType(trainingCentres, openCentres, closedCentres, fullCentres);

        return new MappedDTO(month, traineesWaiting, traineesTraining, openCentres, closedCentres, fullCentres);
    }

    private static void getCentreCountByType(ArrayList<TrainingCentre> trainingCentres, HashMap<TrainingCentreType, Integer> openCentres, HashMap<TrainingCentreType, Integer> closedCentres, HashMap<TrainingCentreType, Integer> fullCentres) {
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

    private static void getTraineeCountByCourse(ArrayList<Trainee> trainees,  HashMap<CourseType, Integer> traineeMap) {
        for (CourseType course: CourseType.values()) {
            long traineeCount = trainees.stream()
                    .filter(e -> e.getCourseType() == course)
                    .count();
            traineeMap.put(course, (int) traineeCount);
        }
    }

    private static void getTraineesTraining(ArrayList<TrainingCentre> trainingCentres, HashMap<CourseType, Integer> traineeMap) {
        ArrayList<Trainee> trainees = new ArrayList<>();

        for (TrainingCentre centre: trainingCentres) {
            trainees.addAll(centre.getCurrentTrainees());
        }

        getTraineeCountByCourse(trainees, traineeMap);
    }

    private static void incrementHashMap(HashMap<TrainingCentreType, Integer> hasMap, TrainingCentreType type) {
        Integer amount = hasMap.get(type);
        hasMap.put(type, ++amount);
    }
}
