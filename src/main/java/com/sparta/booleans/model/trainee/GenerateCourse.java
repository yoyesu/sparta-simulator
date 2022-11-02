package com.sparta.booleans.model.trainee;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.Randomizer;

public class GenerateCourse {
    private CourseType courseType;

    public CourseType generateCourse(CourseType courseType){

        int randomNumber = Randomizer.getRandomCourse();
        if(randomNumber == 1){this.courseType = CourseType.JAVA;}
        else if(randomNumber == 2){this.courseType = CourseType.CSHARP;}
        else if(randomNumber == 3){this.courseType = CourseType.DATA;}
        else if(randomNumber == 4){this.courseType = CourseType.DEVOPS;}
        else if(randomNumber == 5){this.courseType = CourseType.BUSINESS;}
        return courseType;
    }
}
