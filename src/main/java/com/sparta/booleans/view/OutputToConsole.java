package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;


public class OutputToConsole implements OutputInterface{
    public static void outputToConsole(MappedDTO simulationData)
    {
        System.out.println("+-----------------------------------------+");
        System.out.println("Number of months simulation ran for: " + simulationData.getTotalMonths());
        System.out.println("\n\nTrainees: \n");
        for (CourseType type: CourseType.values()) {
            System.out.println(type.name() + " Trainees: ");
            System.out.println(" -> Training: "
                    + simulationData.getTraineesTraining().get(type));
            System.out.println(" -> Waiting: "
                    + simulationData.getTraineesWaiting().get(type));
            System.out.println(" -> Without a Client: "
                    + simulationData.getTraineesOnBench().get(type));
            System.out.println(" -> With Clients: "
                    + simulationData.getTraineesWithClient().get(type));
        }
        System.out.println("\n\nTraining Centres: \n");
        for (TrainingCentreType type: TrainingCentreType.values()) {
            System.out.println(type.name() + ": ");
            System.out.println(" -> Total Opened: "
                    + simulationData.getOpenCentres().get(type));
            System.out.println("    of which, ");
            System.out.println("             -> Currently Full: "
                    + simulationData.getFullCentres().get(type));
            System.out.println("             -> Currently Closed: "
                    + simulationData.getClosedCentres().get(type));
        }
        System.out.println("\n\nClients: \n");
        System.out.println(" -> Happy Clients: " + simulationData.getHappyClients());
        System.out.println(" -> Unhappy Clients: " + simulationData.getUnhappyClients());
        System.out.println("+-----------------------------------------+");
    }


    @Override
    public void sendOutput(MappedDTO simulationData) {
        outputToConsole(simulationData);
    }
}
