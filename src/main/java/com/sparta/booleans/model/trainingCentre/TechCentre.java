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
    }
    public TechCentre(int dateCreated, int centreID) {
        super(dateCreated, centreID);
        courseType = GenerateCourse.generateCourse();
    }

    // Getter
    public CourseType getCourseType() {return courseType;}

    // Methods
    @Override
    boolean shouldBeClosed() {
        return currentTrainees.size() < 25;
    }
}
