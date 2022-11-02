package com.sparta.booleans.utility.random;

import java.util.Random;

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

    public static int getRandomCourse () {
        Random random = new Random();
        int newCourseType = random.nextInt(6);
        return newCourseType;
    }

    public static int getRandomCentre () {
        Random random = new Random();
        int newCentreType = random.nextInt(3);
        return newCentreType;
    }
}
