package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.DTO;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;
import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVWriter implements OutputInterface {

    public Logger logger = CustomLoggerConfiguration.myLogger;

    private static final String CSV_FILE_NAME = "src/main/resources/simulation_report.csv";
    private static final List<List<String>> simulationOutputs = new ArrayList<>(new ArrayList<>());

    @Override
    public void sendOutput(MappedDTO simulationData) {
        if( simulationData == null) {
            throw new IllegalArgumentException("DTO must not be null");
        }
        logger.log(Level.INFO, " Simulation Data has been accepted into ");
        acceptSimulationData(simulationData);
    }

    // Takes a list of DTOs, one for each contiguous run of the simulation
    // Converts each DTO to a line (String)
    private void acceptSimulationData(MappedDTO simulationData) {
        List<String> data = new ArrayList<>();


        for (CourseType type: CourseType.values()) {
            int waiting = simulationData.getTraineesWaiting().get(type);
            int training = simulationData.getTraineesTraining().get(type);
            data.add("" + waiting);
            data.add("" + training);
        }

        for (TrainingCentreType type: TrainingCentreType.values()) {
            int open = simulationData.getOpenCentres().get(type);
            int closed = simulationData.getClosedCentres().get(type);
            int full = simulationData.getFullCentres().get(type);

            data.add("" + open);
            data.add("" + closed);
            data.add("" + full);
        }

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
            pw.append(produceHeader());
            simulationOutputs.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String produceHeader() {
        String header = "Total Months,";
        for (CourseType type: CourseType.values()) {
            header += type.name() + " Trainees Waiting,"
                    + type.name() + " Trainees Training,";
        }
        for (TrainingCentreType type: TrainingCentreType.values()) {
            header+= type.name() + "S Open,"
                    + type.name() + "S Closed,"
                    + type.name() + "S Full,";
        }
        return header.replaceAll(",$", "\n");
    }





}
