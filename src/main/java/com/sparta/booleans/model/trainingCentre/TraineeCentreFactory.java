package com.sparta.booleans.model.trainingCentre;

public class TraineeCentreFactory {

    static public TrainingCentre createTrainingCentre(int var1, int dateCreated, int centreID) {

        switch (var1) {

            case 1 -> {return new Hub(dateCreated, centreID);}
            case 2 -> {return new TechCentre(dateCreated, centreID);}
            case 3 -> {return new Bootcamp(dateCreated,centreID);}
            default -> {return null;}
        }
    }
}
