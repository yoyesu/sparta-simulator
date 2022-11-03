package com.sparta.booleans.util;

import com.sparta.booleans.exceptions.CourseTypeNotFound;
import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.Randomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomizerTest {

    private int maxBound = 100;

    @Test
    @DisplayName("Testing getRandomTrainees method returns integer between 50 & 100")
    public void testGetRandomTrainees() {
        int i = 100;
        while (i!=0) {
//            System.out.println(Randomizer.getRandomTrainees());
            Assertions.assertTrue(50 <= Randomizer.getRandomTrainees() && 100 >= Randomizer.getRandomTrainees());
            i--;
        }
    }

    @Test
    @DisplayName("Testing getRandomCentreIntake method returns integer between 0 & 50")
    public void testGetRandomCentreIntake() {
        int i = 100;
        while (i!=0) {
//            System.out.println(Randomizer.getRandomCentreIntake());
            Assertions.assertTrue(Randomizer.getRandomCentreIntake() <=50);
            i--;
        }
    }

    @Test
    @DisplayName("Testing parameterized getRandomCentreIntake method returns integer less than the maxBound input")
    public void testParameterizedGetRandomCentreIntake() {
        int i = 100;
        while (i!=0) {
//            System.out.println(Randomizer.getRandomCentreIntake(maxBound));
            Assertions.assertTrue(Randomizer.getRandomCentreIntake(maxBound) <= maxBound);
            i--;
        }
    }

    @Test
    @DisplayName("Testing generateCourse method returns CourseType")
    public void testGenerateCourse() {
//        int i = 100;
//        while (i != 0) {
        System.out.println(Randomizer.generateCourse());

        Assertions.assertTrue(Randomizer.generateCourse() == CourseType.JAVA ||
                Randomizer.generateCourse() == CourseType.CSHARP ||
                Randomizer.generateCourse() == CourseType.BUSINESS ||
                Randomizer.generateCourse() == CourseType.DATA ||
                Randomizer.generateCourse() == CourseType.DEVOPS
        );
////
//            i--;
////            Assertions.assertThrows(CourseTypeNotFound.class, Randomizer::generateCourse);
//        }
    }
}
