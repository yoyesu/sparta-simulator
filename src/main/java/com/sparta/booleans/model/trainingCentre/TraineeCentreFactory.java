package com.sparta.booleans.model.trainingCentre;

import java.util.Random;

public class TraineeCentreFactory {

    private static int bootCampCount = 0;

    static public TrainingCentre createTrainingCentre(int dateCreated, int centreID) {

        switch (new Random().nextInt(4)) {

            case 1 -> {return new Hub(dateCreated, centreID);}
            case 2 -> {return new TechCentre(dateCreated, centreID);}
            case 3 -> {
                if(bootCampCount < 2) {
                    bootCampCount++;
                    return new Bootcamp(dateCreated, centreID);
                }
                else return createTrainingCentre(dateCreated, centreID);
            }
            default -> {return null;}
        }
    }
}
