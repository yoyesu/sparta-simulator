package com.sparta.booLeans.simulator;

import com.sparta.booLeans.simulator.trainee.Trainee;
import com.sparta.booLeans.simulator.trainingCentre.TrainingCentre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingCentreTEST {

    @Test
    @DisplayName("Check that isFull returns false")
    void checkReturnsFalse() {
        
        TrainingCentre trainingCentre = new TrainingCentre();
        Assertions.assertEquals(false, trainingCentre.isFull());
    }

    @Test
    @DisplayName("Check that isFull returns true")
    void checkReturnsTrue() {

        TrainingCentre trainingCentre = new TrainingCentre();
        Trainee[] trainees = new Trainee[100];

        // Add items to trainingCentre
        for (int i = 0; i < 100; i++) {
            trainees[i] = new Trainee();
            trainingCentre.currentTrainees.add(trainees[i]);
        }

        Assertions.assertEquals(true, trainingCentre.isFull());
    }
}
