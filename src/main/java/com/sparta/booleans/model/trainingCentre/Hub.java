package com.sparta.booleans.model.trainingCentre;

public class Hub extends TrainingCentre{

    // Constructor
    public Hub(int dateCreated, int centreID) {

        super(dateCreated, centreID);
    }
    public Hub(int dateCreated, int centreID, int monthlyIntake) {

        super(dateCreated, centreID, monthlyIntake);
    }

    // Methods
    @Override
    public boolean shouldBeClosed(int month) {
        return currentTrainees.size() < 25 && month > dateCreated;
    }
}
