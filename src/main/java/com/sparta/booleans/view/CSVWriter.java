package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;
import com.sparta.booleans.utility.logging.CustomLoggerConfiguration;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVWriter implements OutputInterface {

    public Logger logger = CustomLoggerConfiguration.myLogger;

    private String CSV_FILE_NAME;
    private final List<List<String>> simulationOutputs = new ArrayList<>(new ArrayList<>());

    public CSVWriter() {
        LocalDateTime time = LocalDateTime.now();
        this.CSV_FILE_NAME = "src/main/resources/simulation_report("
                + time.format(DateTimeFormatter.ofPattern("YYYY-MM-dd_HH-mm-ss-SS"))
                + ").csv";
    }

    @Override
    public void sendOutput(MappedDTO simulationData) {
        if (simulationData == null) {
            throw new IllegalArgumentException("DTO must not be null");
        }
        logger.log(Level.INFO, " Simulation Data has been accepted into ");
        acceptSimulationData(simulationData);
    }

    // Takes a list of DTOs, one for each contiguous run of the simulation
    // Converts each DTO to a line (String)
    private void acceptSimulationData(MappedDTO simulationData) {
        List<String> data = new ArrayList<>();

        data.add("" + simulationData.getTotalMonths());
        for (CourseType type : CourseType.values()) {
            int waiting = simulationData.getTraineesWaiting().get(type);
            int training = simulationData.getTraineesTraining().get(type);
            int benched = simulationData.getTraineesOnBench().get(type);
            int withClient = simulationData.getTraineesWithClient().get(type);
            data.add("" + waiting);
            data.add("" + training);
            data.add("" + benched);
            data.add("" + withClient);
        }

        for (TrainingCentreType type : TrainingCentreType.values()) {
            int open = simulationData.getOpenCentres().get(type);
            int closed = simulationData.getClosedCentres().get(type);
            int full = simulationData.getFullCentres().get(type);
            data.add("" + open);
            data.add("" + closed);
            data.add("" + full);
        }
        data.add("" + simulationData.getHappyClients());
        data.add("" + simulationData.getUnhappyClients());

        simulationOutputs.add(data);
    }

    private String convertToCSV(List<String> data) {
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
        String header = "Total_Months,";
        for (CourseType type : CourseType.values()) {
            header += type.name() + "_Trainees_Waiting,"
                    + type.name() + "_Trainees_Training,"
                    + type.name() + "_Trainees_On_Bench"
                    + type.name() + "_Trainees_With_Client";
        }
        for (TrainingCentreType type : TrainingCentreType.values()) {
            header += type.name() + "S_Open,"
                    + type.name() + "S_Closed,"
                    + type.name() + "S_Full,";
        }
        header += "Happy_Clients,Unhappy_Clients\n";
        return header;
    }


}
