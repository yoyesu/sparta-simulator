package com.sparta.booleans.model.trainingCentre;

public class Bootcamp extends TrainingCentre{

    // Fields
    int counter = 0;

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

        if(currentTrainees.size() < 25) counter++;
        else counter = 0;
        return counter == 3;
    }
}
