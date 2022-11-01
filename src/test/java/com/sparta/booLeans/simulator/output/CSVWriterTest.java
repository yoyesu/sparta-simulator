package com.sparta.booLeans.simulator.output;

import com.sparta.booleans.simulator.model.DTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVWriterTest {

    static DTO sample1 = new DTO();
    static DTO sample2 = new DTO();
    static DTO sample3 = new DTO();

    CSVWriter writer = new CSVWriter();


    @BeforeEach
    void setup() {

        sample1.setTotalMonths(12);
        sample1.setFullCentres(8);
        sample1.setOpenCentres(16);
        sample1.setTotalTrainees(300);
        sample1.setWaitingTrainees(56);


        sample2.setTotalMonths(12);
        sample2.setFullCentres(8);
        sample2.setOpenCentres(16);
        sample2.setTotalTrainees(300);
        sample2.setWaitingTrainees(56);


        sample3.setTotalMonths(12);
        sample3.setFullCentres(8);
        sample3.setOpenCentres(16);
        sample3.setTotalTrainees(300);
        sample3.setWaitingTrainees(56);

    }


    @Test
    void sendOutput() {

        writer.sendOutput(sample1);
        writer.sendOutput(sample2);
        writer.sendOutput(sample3);

        writer.writeToFile();

    }

    @Test
    void acceptSimulationData() {
    }

    @Test
    void convertToCSV() {
    }

    @Test
    void writeToFile() {
    }
}