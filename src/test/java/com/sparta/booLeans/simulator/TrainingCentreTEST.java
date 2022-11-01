package com.sparta.booLeans.simulator;

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

        // Add items to trainingCentre
        for (int i = 0; i < 100; i++) {
            trainingCentre.currentTrainees.add(i);
        }

        Assertions.assertEquals(true, trainingCentre.isFull());
    }
}
