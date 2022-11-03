package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.DTO;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;


public class OutputToConsole implements OutputInterface{
    public static void outputToConsole(MappedDTO simulationData)
    {
        System.out.println("+-----------------------------------------+");
        System.out.println("Number of months simulation ran for: " + simulationData.getTotalMonths());
        System.out.println("\nTrainees: ");
        for (CourseType type: CourseType.values()) {
            System.out.println(type.name() + " Trainees Training: "
                    + simulationData.getTraineesTraining().get(type));
            System.out.println(type.name() + " Trainees Waiting: "
                    + simulationData.getTraineesWaiting().get(type));
        }
        System.out.println("\nTraining Centres: ");
        for (TrainingCentreType type: TrainingCentreType.values()) {
            System.out.println(type.name() + "S Open: "
                    + simulationData.getOpenCentres().get(type));
            System.out.println(type.name() + "S Closed: "
                    + simulationData.getClosedCentres().get(type));
            System.out.println(type.name() + "S Full: "
                    + simulationData.getFullCentres().get(type));
        }
        System.out.println("+-----------------------------------------+");
    }


    @Override
    public void sendOutput(MappedDTO simulationData) {
        outputToConsole(simulationData);
    }
}
