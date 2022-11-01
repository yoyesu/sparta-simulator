package com.sparta.booleans.view;

import com.sparta.booleans.model.DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter implements OutputInterface {

    private static final String CSV_FILE_NAME = "src/main/resources/simulation_report.csv";
    private static List<List<String>> simulationOutputs = new ArrayList<>(new ArrayList<>());

    @Override
    public void sendOutput(DTO simulationData) {
        acceptSimulationData(simulationData);
    }

    // Takes a list of DTOs, one for each contiguous run of the simulation
    // Converts each DTO to a line (String)
    public void acceptSimulationData(DTO simulationData) {
        List<String> data = new ArrayList<>();

        data.add(String.valueOf(simulationData.getOpenCentres()));
        data.add(String.valueOf(simulationData.getFullCentres()));
        data.add(String.valueOf(simulationData.getTotalTrainees()));
        data.add(String.valueOf(simulationData.getWaitingTrainees()));
        data.add(String.valueOf(simulationData.getTotalMonths()));

        simulationOutputs.add(data);
    }

    public String convertToCSV(List<String> data){
        return String.join(",", data);
    }

    public void writeToFile() {

        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            simulationOutputs.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }





}
