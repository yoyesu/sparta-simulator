package com.sparta.booleans.simulator.output;

import com.sparta.booleans.simulator.model.DTO;

import java.util.List;

public class CSVWriter implements OutputInterface{

    @Override
    public void sendOutput(DTO simulationData) {

    }

    // Takes a list of DTOs, one for each contiguous run of the simulation
    // Converts each DTO to a line (String)
    public String convertToCSV(List<DTO> simulationData) {
        return null;

    }
}
