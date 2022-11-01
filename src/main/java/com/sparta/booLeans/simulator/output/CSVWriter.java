package com.sparta.booleans.simulator.output;

import java.util.Map;

public class CSVWriter implements OutputInterface{


    @Override
    public void sendOutput(Map<String, Integer> simulationData) {

        if (simulationData.size() < 5) {
            throw new IllegalArgumentException("simulationData does not contain sufficient data entries");
        }



    }
}
