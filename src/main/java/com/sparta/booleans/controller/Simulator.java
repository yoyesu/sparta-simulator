package com.sparta.booleans.controller;

import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.exceptions.TraineeNotFoundException;
import com.sparta.booleans.model.DTOGenerator;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainingCentre.*;
import com.sparta.booleans.model.waitinglist.WaitingList;
import com.sparta.booleans.utility.random.Randomizer;

import java.util.ArrayList;

public class Simulator {

    private static int traineeID = 1;
    private static int centreID = 1;
    private static int month = -1;

    private static WaitingList waitingList = new WaitingList();
    private static WaitingList benchedList = new WaitingList();
    private static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public static MappedDTO runSimulation(int months) {
        for (int i = 0; i < months; i++) {
            month++;

            handleClients();

            Trainee[] trainees = generateTrainees(month);
            waitingList.add(trainees);

            generateTrainingCentre();
            closeTrainingCentres();

            int totalIntake = generateTrainingCentreMonthlyIntake();

            int centerIndex = 0;
            while (totalIntake > 0) {
                TrainingCentre centre = trainingCentres.get(centerIndex);
                if (waitingList.getSize() > 0) {
                    if (centre.getMonthlyIntake() > 0 && !centre.isFull() && !centre.getIsClosed()) {
                        Trainee trainee = waitingList.peek();
                        try {
                            if (centre instanceof TechCentre) {
                                trainee = waitingList.pollType(((TechCentre) centre).getCourseType());
                            } else {
                                trainee = waitingList.poll();
                            }
                            centre.addTrainee(trainee);
                            trainee.setTraining(true);
                            trainee.setStartTrainingMonth(month);
                            totalIntake--;

                        } catch (CapacityExceededException e) {
                            waitingList.addToFront(trainee);
                        } catch (TraineeNotFoundException e) {
                            totalIntake -= centre.getMonthlyIntake();
                            centre.setMonthlyIntake(0);
                        }
                    }
                    centerIndex++;
                    if (centerIndex == trainingCentres.size()) {
                        centerIndex = 0;
                    }
                } else {
                    break;
                }
            }
        }
        return DTOGenerator.generateDTO(month + 1, waitingList.toArrayList(), trainingCentres);
    }

    private static Trainee[] generateTrainees(int month) {
        Trainee[] trainees = new Trainee[Randomizer.getRandomTrainees()];
        for (int i = 0; i < trainees.length; i++) {
            trainees[i] = new Trainee(traineeID++, month);
        }
        return trainees;
    }

    private static void generateTrainingCentre() {
        if (month % 2 == 0 && month != 0) {
            TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(month, centreID++);
            if (trainingCentre instanceof Hub) {
                trainingCentres.add(new Hub(month, centreID++));
                trainingCentres.add(new Hub(month, centreID++));
            }
            trainingCentres.add(trainingCentre);
        }
    }

    private static int generateTrainingCentreMonthlyIntake() {
        int totalIntake = 0;
        for (TrainingCentre centre : trainingCentres) {
            if (!centre.isFull() && !centre.getIsClosed()) {
                int monthlyIntake = Randomizer.getRandomCentreIntake();
                if (monthlyIntake > centre.getVacancies()) {
                    monthlyIntake = centre.getVacancies();
                }
                centre.setMonthlyIntake(monthlyIntake);
                totalIntake += monthlyIntake;
            } else {
                centre.setMonthlyIntake(0);
            }
        }
        return totalIntake;
    }

    private static void closeTrainingCentres() {
        for (TrainingCentre centre : trainingCentres) {
            if (centre.shouldBeClosed(month)) {
                for (Trainee trainee : centre.getCurrentTrainees()) {
                    waitingList.add(trainee);
                }
                centre.setIsClosed(true);
            }
        }
    }

    private static void handleClients() {
        benchTrainees();
        createClientAndRequirements();
        assignBenchedToClient();
    }

    private static void createClientAndRequirements() {
        if (month % 12 == 0 && month != 0) {
            clients.add(new Client());
            //add requirement every 12 month
            //check if client is happy after 12 months
            for(Client client : clients){
                if(client.IsActive()) {

                }
            }
        }
    }

    private static void benchTrainees() {
        for (TrainingCentre trainingCentre : trainingCentres) {
            for (Trainee trainee : trainingCentre.getCurrentTrainees()) {
                if (trainee.getStartTrainingMonth() - month > 12) {
                    trainingCentre.benchTrainee(trainee);
                    benchedList.add(trainee);
                }
            }

        }
    }

    private static void assignBenchedToClient() {
        //check if client happy before adding more benched trainees
        for (Client client : clients) {
            if(client.IsActive()) {
                for (Requirement req : client.getRequiredSkills()) {
                    int countToRecruit = Randomizer.getRandomAssignedCount(req.getNumberOfConsultants());
                    if (countToRecruit > req.get()) {
                        countToRecruit = req.get();
                    }
                    for (int i = 0; i < countToRecruit; i++) {
                        try {
                            client.assignTrainee(benchedList.pollType(req.getRequirementType()));
                        } catch (TraineeNotFoundException e) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
