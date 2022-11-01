package com.sparta.booleans.view;

import com.sparta.booleans.model.DTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CSVWriterTest {

    static DTO sample1 = new DTO();
    static DTO sample2 = new DTO();
    static DTO sample3 = new DTO();

    CSVWriter writer = new CSVWriter();


    @BeforeEach
    void setup() {

        sample1.setTotalMonths(15);
        sample1.setFullCentres(11);
        sample1.setOpenCentres(14);
        sample1.setTotalTrainees(280);
        sample1.setWaitingTrainees(49);


        sample2.setTotalMonths(12);
        sample2.setFullCentres(8);
        sample2.setOpenCentres(16);
        sample2.setTotalTrainees(300);
        sample2.setWaitingTrainees(56);


        sample3.setTotalMonths(13);
        sample3.setFullCentres(9);
        sample3.setOpenCentres(17);
        sample3.setTotalTrainees(150);
        sample3.setWaitingTrainees(38);

    }


    @Test
    void sendOutput() {

        writer.sendOutput(sample1);
        writer.sendOutput(sample2);
        writer.sendOutput(sample3);

        writer.writeToFile();

    }
}