package com.sparta.booleans.model.trainingCentre;

public class Bootcamp extends TrainingCentre{

    // Constructor
    public Bootcamp(int dateCreated, int centreID, int monthlyIntake) {
        super(dateCreated, centreID, monthlyIntake);
    }

    public Bootcamp(int dateCreated, int centreID) {
        super(dateCreated, centreID);
    }

    // Methods
    @Override
    boolean shouldBeClosed() {
        return false;
    }
}
