package com.sparta.booleans.view;

import com.sparta.booleans.model.DTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter implements OutputInterface {

    private static final String CSV_FILE_NAME = "src/main/resources/simulation_report.csv";
    private static final List<List<String>> simulationOutputs = new ArrayList<>(new ArrayList<>());

    @Override
    public void sendOutput(DTO simulationData) {
        if( simulationData == null) {
            throw new IllegalArgumentException("DTO must not be null");
        }
        acceptSimulationData(simulationData);
    }

    // Takes a list of DTOs, one for each contiguous run of the simulation
    // Converts each DTO to a line (String)
    private void acceptSimulationData(DTO simulationData) {
        List<String> data = new ArrayList<>();

        data.add(String.valueOf(simulationData.getOpenCentres()));
        data.add(String.valueOf(simulationData.getFullCentres()));
        data.add(String.valueOf(simulationData.getTotalTrainees()));
        data.add(String.valueOf(simulationData.getWaitingTrainees()));
        data.add(String.valueOf(simulationData.getTotalMonths()));

        simulationOutputs.add(data);
    }

    private String convertToCSV(List<String> data){
        return String.join(",", data);
    }

    /* It writes all accepted simulation DTOs together into one CSV file.
     * >>> IT WRITES A HEADER **
     */
    public void writeToFile() {

        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.append("Open Centres, Full Centres, Total Trainees, Unallocated Trainees, Simulation Time in Months \n");
            simulationOutputs.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }





}
