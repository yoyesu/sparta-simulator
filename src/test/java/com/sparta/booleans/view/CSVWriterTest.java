package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;

import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CSVWriterTest {

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

    }

    @Test
    void writeToFile() {
    }
}