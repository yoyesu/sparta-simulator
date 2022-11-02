package com.sparta.booleans.model.trainingCentre;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.GenerateCourse;

public class TechCentre extends TrainingCentre{

    // Fields
    CourseType courseType;

    // Constructor
    public TechCentre(int dateCreated, int centreID, int monthlyIntake) {
        super(dateCreated, centreID, monthlyIntake);
        courseType = GenerateCourse.generateCourse();
        capacity = 200;
    }
    public TechCentre(int dateCreated, int centreID) {
        super(dateCreated, centreID);
        courseType = GenerateCourse.generateCourse();
        capacity = 200;
    }

    // Getter
    public CourseType getCourseType() {return courseType;}

    // Methods
    @Override
    public boolean shouldBeClosed() {
        return currentTrainees.size() < 25;
    }
}
