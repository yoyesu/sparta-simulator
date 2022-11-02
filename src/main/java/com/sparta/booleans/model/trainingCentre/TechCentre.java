package com.sparta.booleans.model.trainingCentre;

import com.sparta.booleans.model.CourseType;

public class TechCentre extends TrainingCentre{

    // Fields
    CourseType courseType;

    // Constructor
    public TechCentre(int dateCreated, int centreID, int monthlyIntake) {
        super(dateCreated, centreID, monthlyIntake);
    }

    public TechCentre(int dateCreated, int centreID) {
        super(dateCreated, centreID);
    }

    // Methods
    @Override
    boolean shouldBeClosed() {
        return false;
    }
}
