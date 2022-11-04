package com.sparta.booleans.model;

import com.sparta.booleans.exceptions.UnknownTrainingCentre;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.model.trainingCentre.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrainingCentreTester {

    @BeforeEach
    void runBeforeTests() {
        TraineeCentreFactory.resetBootCampCount();
    }

    @Test
    @DisplayName("Check that isFull returns false")
    void checkIsFullReturnsFalse() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(1, 21);
        Assertions.assertFalse(trainingCentre.isFull());
    }

    @Test
    @DisplayName("Check that isFull returns true")
    void checkIsFullReturnsTrue() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(1, 21);
        Trainee[] trainees = new Trainee[trainingCentre.getCapacity()];

        // Add items to trainingCentre
        for (int i = 0; i < trainingCentre.getCapacity(); i++) {
            trainees[i] = new Trainee(10,10);
            try {
                trainingCentre.addTrainee(trainees[i]);
            } catch (CapacityExceededException e) {
                e.getMessage();
            }
        }
        Assertions.assertTrue(trainingCentre.isFull());
    }

    @Test
    @DisplayName("Check is CapacityExceededException is thrown")
    void checkCapacityExceededException() {

        Assertions.assertThrows(CapacityExceededException.class, () -> {

            TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(1, 21);;
            Trainee[] trainees = new Trainee[trainingCentre.getCapacity() + 1];

            for (int i = 0; i < trainingCentre.getCapacity() + 1; i++) {
                trainees[i] = new Trainee(10,10);
                trainingCentre.addTrainee(trainees[i]);
            }
        });
    }

    @Test
    @DisplayName("Check is UnknownTrainingCentre is thrown")
    void checkUnknownTrainingCentreException() {

        Assertions.assertThrows(UnknownTrainingCentre.class, () -> {

            TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(12,12, 5);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("Check Exceptions is not thrown")
    void checkUnknownTrainingCentreExceptionIsNotThrown(int values) {

        Assertions.assertDoesNotThrow(() -> {

            TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(12,1, values);
        });
    }

    @Test
    @DisplayName("Check Vacancies equals capacity")
    void checkVacanciesEqualsCapacity() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,1);

        Assertions.assertEquals(trainingCentre.getCapacity(), trainingCentre.getVacancies());
    }

    @Test
    @DisplayName("Check Vacancies differs from capacity")
    void checkVacanciesDiffersCapacity() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,1);
        Trainee trainee = new Trainee(1,2);
        trainingCentre.addTrainee(trainee);

        Assertions.assertNotEquals(trainingCentre.getCapacity(), trainingCentre.getVacancies());
    }

    @Test
    @DisplayName("Check Trainee is added")
    void checkTraineeIsAdded() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,1);
        Trainee trainee = new Trainee(1,2);
        trainingCentre.addTrainee(trainee);

        Assertions.assertEquals(1, trainingCentre.getCurrentTrainees().size());
    }

//    @Test
//    @DisplayName("Check Only Two Bootcamps Exist")
//    void checkOnlyTwoBootcampsExist() {
//
//        TrainingCentre[] trainingCentres = new TrainingCentre[10000];
//        int bootcampCount = 0;
//
//        // Create 10000 Training Centers
//        for(int i = 0; i < 10000; i++) {
//
//            trainingCentres[i] = TraineeCentreFactory.createTrainingCentre(i+1, i);
//            if(trainingCentres[i] instanceof Bootcamp) bootcampCount++;
//        }
//        boolean check = bootcampCount == 0 || bootcampCount == 1 || bootcampCount == 2;
//        Assertions.assertTrue(check);
//    }

    @Test
    @DisplayName("Check Open for How Long")
    void checkCheckOpenHowLong() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(4, 10);
        Assertions.assertEquals(2, trainingCentre.openHowLong(6));
    }

    @Test
    @DisplayName("Check Should be Closed is true")
    void checkShouldBeClosed() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,12,1);

        Assertions.assertEquals(true, trainingCentre.shouldBeClosed(6));
    }

    @Test
    @DisplayName("Check Bootcamp is Created")
    void checkBootcampIsCreated() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,12,2);
        Assertions.assertInstanceOf(Bootcamp.class, trainingCentre);
    }

    @Test
    @DisplayName("Check Trainee Size is 0")
    void checkTraineeSizeIs0() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,12,2);
        Assertions.assertEquals(0, trainingCentre.getCurrentTrainees().size());
    }

    @Test
    @DisplayName("Check (Bootcamp) Should be Closed is false")
    void checkShouldBeClosedBootcamp1() {

        TrainingCentre trainingCentre = TraineeCentreFactory.createTrainingCentre(2,12,2);
        Trainee[] trainees = new Trainee[25];

        for(int i=0; i<25; i++) {
            trainees[i] = new Trainee(i, 2);
            trainingCentre.addTrainee(trainees[i]);
        }

        Assertions.assertFalse(trainingCentre.shouldBeClosed(6));
    }
}
