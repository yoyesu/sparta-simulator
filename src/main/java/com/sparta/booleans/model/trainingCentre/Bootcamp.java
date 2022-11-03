package com.sparta.booleans.model.trainingCentre;

public class Bootcamp extends TrainingCentre{

    // Fields
    private int lowAttendanceMonthsCounter = 0;

    // Constructor
    public Bootcamp(int dateCreated, int centreID, int monthlyIntake) {
        super(dateCreated, centreID, monthlyIntake);
        capacity = 500;
    }

    public Bootcamp(int dateCreated, int centreID) {
        super(dateCreated, centreID);
        capacity = 500;
    }

    // Methods
    @Override
    public boolean shouldBeClosed(int month) {

        if(currentTrainees.size() < 25) lowAttendanceMonthsCounter++;
        else lowAttendanceMonthsCounter = 0;
        return lowAttendanceMonthsCounter == 3;
    }
}
