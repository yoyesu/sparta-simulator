package com.sparta.booLeans.simulator;

import com.sparta.booLeans.simulator.waitinglist.WaitingList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class WaitingListTest {

    private WaitingList<Integer> waitingList;

    @BeforeEach
    public void resetSingleton() {
        waitingList = WaitingList.<Integer>generateWaitingList();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("Test elements can be added to the queue")
    void testElementsCanBeAdded(int i) {
        waitingList.add(i);
        Assertions.assertEquals(i, waitingList.peek());
    }

    @Test
    @DisplayName("Test array of elements can be added to the queue")
    void testArrayOfElementsCanBeAdded() {
        Integer[] ints = {1,2,3,4,5};
        waitingList.add(ints);
        Assertions.assertEquals(ints[0], waitingList.peek());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("Test elements can be removed from the queue")
    void testElementsCanBeRemoved(int i) {
        waitingList.add(i);
        waitingList.remove();
        Assertions.assertNull(waitingList.peek());
    }

    @Test
    @DisplayName("Test get size returns the number of elements")
    void testGetSize() {
        Integer[] ints = {1,2,3,4,5};
        waitingList.add(ints);
        Assertions.assertEquals(ints.length, waitingList.getSize());
    }

    @Test
    @DisplayName("Test an element can be popped from the queue")
    void testElementCanBePopped() {
        Integer[] ints = {1,2,3,4,5};
        waitingList.add(ints);
        Assertions.assertEquals(ints[0], waitingList.poll());
        Assertions.assertEquals(ints[1], waitingList.poll());
        Assertions.assertEquals(ints[2], waitingList.peek());
    }

    @Test
    @DisplayName("Test that the WaitingList constructor is private so no objects of it can be created.")
    void testConstructorIsPrivate() throws NoSuchMethodException {
        Assertions.assertEquals(Modifier.PRIVATE, WaitingList.class.getDeclaredConstructor().getModifiers());
    }

}
