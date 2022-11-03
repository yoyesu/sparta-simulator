package com.sparta.booleans.utility.random;

import com.sparta.booleans.exceptions.CourseTypeNotFound;
import com.sparta.booleans.model.CourseType;

import java.util.Random;

import static com.sparta.booleans.model.CourseType.*;

public class Randomizer {

    public static int getRandomTrainees () {
        Random random = new Random();
        int newTrainees = random.nextInt(50,101);
        return newTrainees;
    }

    public static int getRandomCentreIntake () {
        Random random = new Random();
        int newCentreIntake = random.nextInt(51);
        return newCentreIntake;
    }

    public static int getRandomCentreIntake (int maxBound) {
        Random random = new Random();
        //since upper bound is exclusive it wont include the number, so add +1 to include it (make it inclusive)
        int newCentreIntake = random.nextInt(maxBound);
        return newCentreIntake;
    }

    public static CourseType generateCourse() throws CourseTypeNotFound {

        Random random = new Random();
        switch (random.nextInt(CourseType.values().length)) {

            case 0 -> {return JAVA;}
            case 1 -> {return CSHARP;}
            case 2 -> {return DATA;}
            case 3 -> {return DEVOPS;}
            case 4 -> {return BUSINESS;}
            default -> throw new CourseTypeNotFound();
        }
    }

    public static int getRandomAssignedCount(int requirementCount){
        Random random = new Random();
        return random.nextInt(1, requirementCount);
    }
}
