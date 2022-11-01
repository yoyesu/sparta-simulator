package com.sparta.booleans.view;

import com.sparta.booleans.view.input.TimeFrameInputter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeFrameInputterTest {
    TimeFrameInputter timeFrameInputter = new TimeFrameInputter();

    @Test
    @DisplayName("Check 6 months returns 6")
    void check0Y6MReturns6Months() {
        Assertions.assertEquals(6, timeFrameInputter.getTotalMonths(0,6));
    }

    @Test
    @DisplayName("Check 1 year returns 12")
    void check1Y0MReturns12() {
        Assertions.assertEquals(12, timeFrameInputter.getTotalMonths(1,0));
    }

    @Test
    @DisplayName("Check 4 years 3 months returns 51")
    void check4Y3MReturns51() {
        Assertions.assertEquals(51, timeFrameInputter.getTotalMonths(4,3));
    }

    @Test
    @DisplayName("Check 4 years 12 months returns 60")
    void check4Y12MReturns60() {
        Assertions.assertEquals(60, timeFrameInputter.getTotalMonths(4,12));
    }

}
