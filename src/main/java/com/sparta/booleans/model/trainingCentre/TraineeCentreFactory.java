package com.sparta.booleans.model.trainingCentre;

import com.sparta.booleans.exceptions.UnknownTrainingCentre;
import java.util.Random;

public class TraineeCentreFactory {

    // Fields
    private static int bootCampCount = 0;

    // Getters
    public static int getBootCampCount() {return bootCampCount;}

    // Methods
    static public TrainingCentre createTrainingCentre(int dateCreated, int centreID) throws UnknownTrainingCentre {

        switch (new Random().nextInt(3)) {

            case 0 -> {return new Hub(dateCreated, centreID);}
            case 1 -> {return new TechCentre(dateCreated, centreID);}
            case 2 -> {
                if(bootCampCount < 2) {
                    bootCampCount++;
                    return new Bootcamp(dateCreated, centreID);
                }
                else return createTrainingCentre(dateCreated, centreID);
            }
            default -> throw new UnknownTrainingCentre();
        }
    }

    static public TrainingCentre createTrainingCentre(int dateCreated, int centreID, int random) throws UnknownTrainingCentre {

        switch (random) {

            case 0 -> {return new Hub(dateCreated, centreID);}
            case 1 -> {return new TechCentre(dateCreated, centreID);}
            case 2 -> {
                if(bootCampCount < 2) {
                    bootCampCount++;
                    return new Bootcamp(dateCreated, centreID);
                }
                else return createTrainingCentre(dateCreated, centreID, new Random().nextInt(3));
            }
            default -> throw new UnknownTrainingCentre();
        }
    }
}
