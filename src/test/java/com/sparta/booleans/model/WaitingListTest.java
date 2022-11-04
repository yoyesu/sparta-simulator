package com.sparta.booleans.model;

import com.sparta.booleans.exceptions.TraineeNotFoundException;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.model.waitinglist.WaitingList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.stream.Stream;

public class WaitingListTest {

    private WaitingList waitingList = new WaitingList();

    private static Trainee[] getTraineeArray() {
        ArrayList<Trainee> trainees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            trainees.add(new Trainee(i, 0));
            trainees.get(i).setCourseType(CourseType.JAVA);
        }
        return trainees.toArray(Trainee[]::new);
    }

    @BeforeEach
    public void resetWaitingList() {
        while (waitingList.getSize() > 0) {
            waitingList.remove();
        }
    }

    @ParameterizedTest
    @MethodSource("getTraineeArray")
    @DisplayName("Test trainees can be added to the waiting list")
    void testTraineeCanBeAdded(Trainee trainee) {
        waitingList.add(trainee);
        Assertions.assertEquals(trainee, waitingList.peek());
    }

    @Test
    @DisplayName("Test array of trainees can be added to the waiting list")
    void testArrayOfTraineesCanBeAdded() {
        Trainee[] trainees = getTraineeArray();
        waitingList.add(trainees);
        Assertions.assertEquals(trainees[0], waitingList.peek());
    }

    @ParameterizedTest
    @MethodSource("getTraineeArray")
    @DisplayName("Test trainees can be removed from the waiting list")
    void testTraineesCanBeRemoved(Trainee trainee) {
        waitingList.add(trainee);
        waitingList.remove();
        Assertions.assertNull(waitingList.peek());
    }

    @Test
    @DisplayName("Test get size returns the number of trainees")
    void testGetSize() {
        Trainee[] trainees = getTraineeArray();
        waitingList.add(trainees);
        Assertions.assertEquals(trainees.length, waitingList.getSize());
    }

    @Test
    @DisplayName("Test an trainee can be popped from the waiting list")
    void testTraineeCanBePopped() {
        Trainee[] trainees = getTraineeArray();
        waitingList.add(trainees);
        Assertions.assertEquals(trainees[0], waitingList.poll());
        Assertions.assertEquals(trainees[1], waitingList.poll());
        Assertions.assertEquals(trainees[2], waitingList.peek());
    }

    @Test
    @DisplayName("Test an trainee can be popped from the waiting list by course type")
    void testTraineeCanBePoppedByType() {
        Trainee[] trainees = getTraineeArray();
        trainees[0].setCourseType(CourseType.DATA);
        trainees[1].setCourseType(CourseType.JAVA);
        trainees[2].setCourseType(CourseType.DEVOPS);

        waitingList.add(trainees);
        Assertions.assertEquals(trainees[1], waitingList.pollType(CourseType.JAVA));
        Assertions.assertEquals(trainees[2], waitingList.pollType(CourseType.DEVOPS));
        Assertions.assertEquals(trainees[0], waitingList.poll());
        Assertions.assertEquals(trainees[3], waitingList.peek());
    }

    @Test
    @DisplayName("Test an arraylist containing all trainees in the queue can be returned")
    void testTraineeArrayListCanBeReturned() {
        Trainee[] trainees = getTraineeArray();
        waitingList.add(trainees);
        Assertions.assertArrayEquals(trainees, waitingList.toArrayList().toArray());
    }

    @Test
    @DisplayName("Test if an exception is thrown when trying to retrieve a trainee " +
            "of a specific type that isn't in the waiting list.")
    void testExceptionThrown() {
        Trainee[] trainees = getTraineeArray();
        waitingList.add(trainees);
        Assertions.assertThrows(TraineeNotFoundException.class, () -> waitingList.pollType(CourseType.DEVOPS));
    }

    @Test
    @DisplayName("Test if an exception is thrown when trying to retrieve a trainee " +
            "of a specific type from an empty waiting list.")
    void testExceptionThrownWhenEmpty() {
        Assertions.assertThrows(TraineeNotFoundException.class, () -> waitingList.pollType(CourseType.DEVOPS));
    }
}
