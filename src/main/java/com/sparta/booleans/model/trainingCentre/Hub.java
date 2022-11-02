package com.sparta.booleans.model.trainingCentre;

public class Hub extends TrainingCentre{

    // Constructor
    public Hub(int dateCreated, int centreID) {

        super(dateCreated, centreID);
        capacity = 100;
    }
    public Hub(int dateCreated, int centreID, int monthlyIntake) {

        super(dateCreated, centreID, monthlyIntake);
        capacity = 100;
    }

    // Methods
    @Override
    boolean shouldBeClosed() {
        return false;
    }
}
