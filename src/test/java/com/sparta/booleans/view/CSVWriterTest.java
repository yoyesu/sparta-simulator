package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;

import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CSVWriterTest {
    String CSV_FILE_NAME = "src/main/resources/simulation_report.csv";
    HashMap<CourseType, Integer> traineesWaiting = new HashMap<>();
    HashMap<CourseType, Integer> traineesTraining = new HashMap<>();
    HashMap<TrainingCentreType, Integer> openCentres = new HashMap<>();
    HashMap<TrainingCentreType, Integer> closedCentres = new HashMap<>();
    HashMap<TrainingCentreType, Integer> fullCentres = new HashMap<>();

    MappedDTO sample;



    CSVWriter writer = new CSVWriter();


    @BeforeEach
    void setup() {

        traineesWaiting.put(CourseType.BUSINESS, 10);
        traineesWaiting.put(CourseType.JAVA, 20);
        traineesWaiting.put(CourseType.DATA, 30);
        traineesWaiting.put(CourseType.DEVOPS, 40);
        traineesWaiting.put(CourseType.CSHARP, 50);

        traineesTraining.put(CourseType.BUSINESS, 10);
        traineesTraining.put(CourseType.JAVA, 20);
        traineesTraining.put(CourseType.DATA, 30);
        traineesTraining.put(CourseType.DEVOPS, 40);
        traineesTraining.put(CourseType.CSHARP, 50);

        openCentres.put(TrainingCentreType.BOOTCAMP, 10);
        openCentres.put(TrainingCentreType.TECH_CENTRE, 20);
        openCentres.put(TrainingCentreType.TRAINING_HUB, 30);

        closedCentres.put(TrainingCentreType.BOOTCAMP, 10);
        closedCentres.put(TrainingCentreType.TECH_CENTRE, 20);
        closedCentres.put(TrainingCentreType.TRAINING_HUB, 30);

        fullCentres.put(TrainingCentreType.BOOTCAMP, 10);
        fullCentres.put(TrainingCentreType.TECH_CENTRE, 20);
        fullCentres.put(TrainingCentreType.TRAINING_HUB, 30);


        sample = new MappedDTO(12, traineesWaiting, traineesTraining, openCentres, closedCentres, fullCentres);


    }


    @Test
    void testSendOutput() {

        writer.sendOutput(sample);

        writer.writeToFile();

        List<String> expected = new ArrayList<>(List.of("Total Months,JAVA Trainees Waiting,JAVA Trainees Training,CSHARP Trainees Waiting,CSHARP Trainees Training,DATA Trainees Waiting,DATA Trainees Training,DEVOPS Trainees Waiting,DEVOPS Trainees Training,BUSINESS Trainees Waiting,BUSINESS Trainees Training,TECH_CENTRES Open,TECH_CENTRES Closed,TECH_CENTRES Full,BOOTCAMPS Open,BOOTCAMPS Closed,BOOTCAMPS Full,TRAINING_HUBS Open,TRAINING_HUBS Closed,TRAINING_HUBS Full",
                "12,20,20,50,50,30,30,40,40,10,10,20,20,20,10,10,10,30,30,30"));

        Assertions.assertEquals(expected, CSVReader(CSV_FILE_NAME));

    }

    private List<String> CSVReader(String CSV_FILE_NAME) {
        List<String> lines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(CSV_FILE_NAME);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());

            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void writeToFile() {
    }
}