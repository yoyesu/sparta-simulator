package com.sparta.booleans.controller;

import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.model.DTO;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.trainee.TraineeInterface;
import com.sparta.booleans.model.trainingCentre.TrainingCentre;
import com.sparta.booleans.model.waitinglist.WaitingList;
import com.sparta.booleans.utility.random.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Simulator {

    private static int traineeID = 1;
    private static int centreID = 1;

    public static DTO runSimulation(int months) {
        WaitingList<Trainee> waitingList = WaitingList.<Trainee>generateWaitingList();
        ArrayList<TrainingCentre> trainingCentres = new ArrayList<>();

        for (int x = 0; x < months; x++) {
            Trainee[] trainees = generateTrainees(x);
            waitingList.add(trainees);

            if (x % 2 == 0 && x != 0) {
                TrainingCentre trainingCentre = new TrainingCentre(x, centreID++);
                trainingCentres.add(trainingCentre);
            }

            int totalIntake = generateTrainingCentreMonthlyIntake(trainingCentres);

            int centerIndex = 0;
            while (totalIntake > 0) {
                TrainingCentre centre = trainingCentres.get(centerIndex);
                if (waitingList.getSize() > 0) {
                    if (centre.getMonthlyIntake() > 0 && !centre.isFull()) {
                        Trainee trainee = waitingList.poll();
                        try {
                            centre.addTrainee(trainee);
                            trainee.setTraining(true);
                            trainee.setStartTrainingMonth(x);
                            totalIntake--;

                        } catch (CapacityExceededException e) {
                            waitingList.addToFront(trainee);
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
        return getResults(waitingList, trainingCentres, months);
    }

    private static Trainee[] generateTrainees(int month) {
        Trainee[] trainees = new Trainee[Randomizer.getRandomTrainees()];
        for (int i = 0; i < trainees.length; i++) {
            trainees[i] = new Trainee(traineeID++, month);
        }
        return trainees;
    }

    private static int generateTrainingCentreMonthlyIntake(ArrayList<TrainingCentre> trainingCentres) {
        int totalIntake = 0;
        for (TrainingCentre centre: trainingCentres) {
            if (!centre.isFull()) {
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

    private static DTO getResults(WaitingList<Trainee> waitingList,
                                  ArrayList<TrainingCentre> trainingCentres, int months) {
        DTO dto = new DTO();
        int fullCentres = 0;
        int totalTrainees = 0;
        for (TrainingCentre centre: trainingCentres) {
            if (centre.isFull()) {
                fullCentres++;
            }
            totalTrainees += centre.getCurrentTrainees().size();
        }

        dto.setFullCentres(fullCentres);
        dto.setOpenCentres(trainingCentres.size());
        dto.setTotalTrainees(totalTrainees + waitingList.getSize());
        dto.setWaitingTrainees(waitingList.getSize());
        dto.setTotalMonths(months);
        return dto;
    }
}
