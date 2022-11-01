package com.sparta.booleans.model;

import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.model.trainingCentre.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCentreTEST {

    @Test
    @DisplayName("Check that isFull returns false")
    void checkReturnsFalse() {
        
        TrainingCentre trainingCentre = new TrainingCentre(7, 1, 21);
        Assertions.assertEquals(false, trainingCentre.isFull());
    }

    @Test
    @DisplayName("Check that isFull returns true")
    void checkReturnsTrue() {

        TrainingCentre trainingCentre = new TrainingCentre(12, 3, 35);
        Trainee[] trainees = new Trainee[100];

        // Add items to trainingCentre
        for (int i = 0; i < 100; i++) {
            trainees[i] = new Trainee(10,10);
            try {
                trainingCentre.addTrainee(trainees[i]);
            } catch (CapacityExceededException e) {
                e.getMessage();
            }
        }
        Assertions.assertEquals(true, trainingCentre.isFull());
    }

    @Test
    @DisplayName("Check for Exception")
    void checkException() {

        Assertions.assertThrows(CapacityExceededException.class, () -> {

            TrainingCentre trainingCentre = new TrainingCentre(12, 3, 35);
            Trainee[] trainees = new Trainee[102];

            for (int i = 0; i < 102; i++) {
                trainees[i] = new Trainee(10,10);
                trainingCentre.addTrainee(trainees[i]);
            }
        });
    }
}
