package com.sparta.booleans.utility.random;

import com.sparta.booleans.exceptions.CourseTypeNotFound;
import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.Randomizer;

import static com.sparta.booleans.model.CourseType.*;

public class GenerateCourse {

    public static CourseType generateCourse() throws CourseTypeNotFound {

        int randomNumber = Randomizer.getRandomCourse();
        switch (randomNumber) {

            case 1 -> {return JAVA;}
            case 2 -> {return CSHARP;}
            case 3 -> {return DATA;}
            case 4 -> {return DEVOPS;}
            case 5 -> {return BUSINESS;}
            default -> throw new CourseTypeNotFound();
        }
    }
}
