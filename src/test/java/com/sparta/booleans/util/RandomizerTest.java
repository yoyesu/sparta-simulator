package com.sparta.booleans.util;

import com.sparta.booleans.exceptions.CourseTypeNotFound;
import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.Randomizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomizerTest {

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
            int maxBound = 100;
            Assertions.assertTrue(Randomizer.getRandomCentreIntake(maxBound) <= maxBound);
            i--;
        }
    }

    @Test
    @DisplayName("Testing generateCourse method returns CourseType")
    public void testGenerateCourse() {
        int i = 100;
        while (i != 0) {
        System.out.println(Randomizer.generateCourse());

        CourseType type = Randomizer.generateCourse();

        Assertions.assertTrue(CourseType.JAVA.equals(type) ||
                CourseType.CSHARP.equals(type) ||
                CourseType.BUSINESS.equals(type) ||
                CourseType.DATA.equals(type) ||
                CourseType.DEVOPS.equals(type)
        );

            i--;
//          Assertions.assertThrows(CourseTypeNotFound.class, Randomizer::generateCourse);
        }
    }

    @Test
    @DisplayName("Testing generateCourse method does not throw CourseTypeNotFoundException")
    public void testCourseTypeNotFoundException(){
        Assertions.assertDoesNotThrow(Randomizer::generateCourse);
    }
}
