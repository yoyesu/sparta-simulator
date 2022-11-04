package com.sparta.booleans.view;

import com.sparta.booleans.exceptions.InvalidIntInputException;
import com.sparta.booleans.exceptions.InvalidTimeFrameMonthException;
import com.sparta.booleans.view.input.TimeFrameInputter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeFrameInputterTest {
    TimeFrameInputter timeFrameInputter = new TimeFrameInputter();


    @Test
    @DisplayName("Check 1 year returns 12")
    void check1YReturns12() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(12, timeFrameInputter.getTotalMonths());
    }

    @Test
    @DisplayName("Check 10 years returns ")
    void check10YReturns120() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(120, timeFrameInputter.getTotalMonths());
    }

    @Test
    @DisplayName("Check getInputInt(-10) throws InvalidIntInputException")
    public void checkInvalidIntInputException() {
        String input = "-10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InvalidIntInputException e = assertThrows(InvalidIntInputException.class, () -> {
            timeFrameInputter.getInputInt();
        });

        String expectedMessage = "There has been an invalid input, simulation does not accept this input";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Check getMonths(13) returns InvalidTimeFrameMonthException")
    public void checkInvalidTimeFrameMonthException(){
        String input = "13";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InvalidTimeFrameMonthException e = assertThrows(InvalidTimeFrameMonthException.class, () -> {
            timeFrameInputter.getMonths();
        });

        String expectedMessage = "Invalid time entered, max months is 11";
        String actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }








}
