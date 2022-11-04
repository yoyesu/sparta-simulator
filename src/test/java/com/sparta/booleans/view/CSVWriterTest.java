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

    HashMap<CourseType, Integer> traineesWaiting = new HashMap<>();
    HashMap<CourseType, Integer> traineesTraining = new HashMap<>();
    HashMap<CourseType, Integer> traineesOnBench = new HashMap<>();
    HashMap<CourseType, Integer> traineesWithClient = new HashMap<>();
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

        traineesOnBench.put(CourseType.BUSINESS, 10);
        traineesOnBench.put(CourseType.JAVA, 20);
        traineesOnBench.put(CourseType.DATA, 30);
        traineesOnBench.put(CourseType.DEVOPS, 40);
        traineesOnBench.put(CourseType.CSHARP, 50);

        traineesWithClient.put(CourseType.BUSINESS, 10);
        traineesWithClient.put(CourseType.JAVA, 20);
        traineesWithClient.put(CourseType.DATA, 30);
        traineesWithClient.put(CourseType.DEVOPS, 40);
        traineesWithClient.put(CourseType.CSHARP, 50);

        openCentres.put(TrainingCentreType.BOOTCAMP, 3);
        openCentres.put(TrainingCentreType.TECH_CENTRE, 7);
        openCentres.put(TrainingCentreType.TRAINING_HUB, 9);

        closedCentres.put(TrainingCentreType.BOOTCAMP, 3);
        closedCentres.put(TrainingCentreType.TECH_CENTRE, 7);
        closedCentres.put(TrainingCentreType.TRAINING_HUB, 9);

        fullCentres.put(TrainingCentreType.BOOTCAMP, 3);
        fullCentres.put(TrainingCentreType.TECH_CENTRE, 7);
        fullCentres.put(TrainingCentreType.TRAINING_HUB, 9);


        sample = new MappedDTO(12,
                traineesWaiting,
                traineesTraining,
                traineesOnBench,
                traineesWithClient,
                openCentres,
                closedCentres,
                fullCentres, 1, 2);
    }


    @Test
    void testSendOutput() {

        writer.sendOutput(sample);

        writer.writeToFile();

        List<String> expected = new ArrayList<>(List.of(
                "Total_Months,JAVA_Trainees_Waiting,JAVA_Trainees_Training,JAVA_Trainees_On_Bench,JAVA_Trainees_With_Client,CSHARP_Trainees_Waiting,CSHARP_Trainees_Training,CSHARP_Trainees_On_Bench,CSHARP_Trainees_With_Client,DATA_Trainees_Waiting,DATA_Trainees_Training,DATA_Trainees_On_Bench,DATA_Trainees_With_Client,DEVOPS_Trainees_Waiting,DEVOPS_Trainees_Training,DEVOPS_Trainees_On_Bench,DEVOPS_Trainees_With_Client,BUSINESS_Trainees_Waiting,BUSINESS_Trainees_Training,BUSINESS_Trainees_On_Bench,BUSINESS_Trainees_With_Client,TECH_CENTRES_Open,TECH_CENTRES_Closed,TECH_CENTRES_Full,BOOTCAMPS_Open,BOOTCAMPS_Closed,BOOTCAMPS_Full,TRAINING_HUBS_Open,TRAINING_HUBS_Closed,TRAINING_HUBS_Full,Happy_Clients,Unhappy_Clients",
                "12,20,20,20,20,50,50,50,50,30,30,30,30,40,40,40,40,10,10,10,10,7,7,7,3,3,3,9,9,9,1,2"));

        Assertions.assertEquals(expected, CSVReader(writer.getCSV_FILE_NAME()));

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