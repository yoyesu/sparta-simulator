package com.sparta.booleans.model;

import com.sparta.booleans.model.trainee.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TraineeClassTester {
static Trainee trainee1 = new Trainee();
static Trainee trainee2 = new Trainee();
    @BeforeEach
    @DisplayName("Create different trainee objects")
    public void createTrainees(){
        trainee1.setTraineeId(1);
        trainee1.setTraining(true);
        trainee1.setMonthCreated(5);
        trainee1.setStartTrainingMonth(15);

        trainee1.setTraineeId(10);
        trainee1.setTraining(false);
        trainee1.setMonthCreated(15);
        trainee2.setStartTrainingMonth(0);
    }

    @Test
    @DisplayName("Testing if 2 trainee objects are not the same")
    public void traineeChecker(){
        Assertions.assertNotSame(trainee1,trainee2);
    }

    @Test
    @DisplayName("Check if getters return set value")
    public void checkGetters(){
        Assertions.assertEquals(trainee1.getTraineeId(),1);
        Assertions.assertEquals(trainee2.getTraineeId(),10);
        Assertions.assertTrue(trainee1.isTraining());
        Assertions.assertFalse(trainee2.isTraining());
        Assertions.assertEquals(trainee1.getMonthCreated(),5);
        Assertions.assertEquals(trainee2.getMonthCreated(),15);
        Assertions.assertEquals(trainee1.getStartTrainingMonth(),15);
        Assertions.assertEquals(trainee2.getStartTrainingMonth(),16);
    }
}
