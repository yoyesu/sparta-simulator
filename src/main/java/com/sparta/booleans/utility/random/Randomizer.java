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
}
