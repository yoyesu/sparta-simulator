package com.sparta.booleans.controller;

import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.exceptions.TraineeNotFoundException;
import com.sparta.booleans.model.Client.Client;
import com.sparta.booleans.model.Client.Requirement;
import com.sparta.booleans.model.DTOGenerator;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainingCentre.*;
import com.sparta.booleans.model.waitinglist.WaitingList;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;
import com.sparta.booleans.utility.random.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simulator {

    private static int traineeID = 1;
    private static int centreID = 1;
    private static int clientID = 1;
    private static int requirementID = 1;
    private static int month = -1;

    private static WaitingList waitingList = new WaitingList();
    private static WaitingList benchedList = new WaitingList();
    private static ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    public static Logger logger = CustomLoggerConfiguration.myLogger;

    public static MappedDTO runSimulation(int months) {
        for (int i = 0; i < months; i++) {
            logger.log(Level.FINE, "Month " + i + " of simulation:");
            month++;

            handleClients();

            Trainee[] trainees = generateTrainees(month);
            waitingList.add(trainees);
            logger.log(Level.FINER, "Adding " + trainees.length + " trainees to the waiting list");

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
//                                logger.log(Level.FINER, "Adding trainee no. " + trainee.getTraineeId() + " to a TechCentre");
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
        return DTOGenerator.generateDTO(month + 1, waitingList.toArrayList(),
                benchedList.toArrayList(), trainingCentres, clients);
    }

    private static Trainee[] generateTrainees(int month) {
        Trainee[] trainees = new Trainee[Randomizer.getRandomTrainees()];
        for (int i = 0; i < trainees.length; i++) {
            trainees[i] = new Trainee(traineeID++, month);
//            logger.log(Level.FINER, "Trainee no. " + traineeID + " has been generated!");
        }
        logger.log(Level.FINER, trainees.length + " trainees have been generated");
        return trainees;
    }

    private static void generateTrainingCentre() {
        if (month % 2 == 0 && month != 0) {
            TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(month, centreID++);
            if (trainingCentre instanceof Hub) {
                trainingCentres.add(new Hub(month, centreID++));
                trainingCentres.add(new Hub(month, centreID++));
                logger.log(Level.FINER, "2 new training hubs have been generated!");
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
                logger.log(Level.FINER, centre.getClass().getName() + " with centreID " + centre.getCentreID() + " requires " + monthlyIntake + " trainees");
                totalIntake += monthlyIntake;
            } else {
                centre.setMonthlyIntake(0);
                logger.log(Level.FINER, "Training centre " + centre.getClass().getName() + ": with centreID " + centre.getCentreID() + " is full!");
            }
        }
        return totalIntake;
    }

    private static void closeTrainingCentres() {
        int countTrainees =0;
        int countClosedCentres=0;
        for (TrainingCentre centre : trainingCentres) {
            if (centre.shouldBeClosed(month)) {
                for (Trainee trainee : centre.getCurrentTrainees()) {
//                    logger.log(Level.FINEST, "Adding trainee no. " + trainee.getTraineeId() + " to waiting list as training centre is closed!");
                    waitingList.add(trainee);
                    countTrainees++;
                }
                centre.setIsClosed(true);
            }
            countClosedCentres++;
        }
        logger.log(Level.FINER, countClosedCentres + " training centres have closed as requirements haven't been met!");
        logger.log(Level.FINEST, "Adding " + countTrainees + " trainees to waiting list as their training centre has closed!");
    }

    private static void handleClients() {
        benchTrainees();
        createClientAndRequirements();
        assignBenchedToClient();
    }

    private static void createClientAndRequirements() {
        if (month % 11 == 0 && month != 0) {
            for(Client client : clients){
                if(client.isActive() && !client.shouldLeave()) {
                    client.renewRequirement(requirementID++, month);
                }
            }
            Client client = new Client(clientID++, month);
            client.generateRequirement(requirementID++, month, benchedList.getSize());
            clients.add(client);
        }
    }

    private static void benchTrainees() {
        int count =0;
        for (TrainingCentre trainingCentre : trainingCentres) {
            for (Trainee trainee : trainingCentre.getCurrentTrainees()) {
                if (month - trainee.getStartTrainingMonth() > 11) {
                    trainingCentre.benchTrainee(trainee);
                    benchedList.add(trainee);
                    count++;
                }
            }
        }
        logger.log(Level.FINER, "Adding " + count + " trainees to the bench as they have completed their training");
    }

    private static void assignBenchedToClient() {
        int count=0;
        for (Client client : clients) {
            if(client.isActive()) {
                for (Requirement req : client.getRequiredSkills()) {
                    int countToRecruit = Randomizer.getRandomAssignedCount(req.getNumberOfConsultants());
                    if (countToRecruit > req.getTraineesVacancies()) {
                        countToRecruit = req.getTraineesVacancies();
                    }
                    for (int i = 0; i < countToRecruit; i++) {
                        try {
                            client.assignTrainee(benchedList.pollType(req.getRequirementType()));
                            count++;
                            req.reduceAvailableSpace();
                        } catch (TraineeNotFoundException e) {
                            break;
                        }
                    }
                }
            }
        }
        logger.log(Level.FINE,  count + " benched trainees have been assigned to a client");
    }
}