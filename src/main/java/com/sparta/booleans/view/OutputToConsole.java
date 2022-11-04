package com.sparta.booleans.view;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.MappedDTO;
import com.sparta.booleans.model.TrainingCentreType;


public class OutputToConsole implements OutputInterface {
    public static void outputToConsole(MappedDTO simulationData) {
        System.out.println("\n+-----------------------------------------+\n");
        System.out.println("Number of months simulation ran for: " + simulationData.getTotalMonths());
        System.out.println("\n\nTrainees: \n");

        for (CourseType type : CourseType.values()) {
            formatTraineePrint(simulationData, type);
        }

        System.out.println("\n\nTraining Centres: \n");

        for (TrainingCentreType type : TrainingCentreType.values()) {
            formatCentrePrint(simulationData, type);
        }
        System.out.println("\n\nClients: \n");
        System.out.printf("%-25s %6d %n", " -> Happy Clients: ", simulationData.getHappyClients());
        System.out.printf("%-25s %6d %n", " -> Unhappy Clients: ", simulationData.getUnhappyClients());
        System.out.println("\n+-----------------------------------------+\n");
    }


    private static void formatTraineePrint(MappedDTO simulationData, CourseType type) {

        System.out.printf(" %s %n", "COURSE: " + type.name());
        System.out.printf("%-25s %6d %n", " -> In training: "
                , simulationData.getTraineesTraining().get(type));
        System.out.printf("%-25s %6d %n", " -> Waiting: "
                , simulationData.getTraineesWaiting().get(type));
        System.out.printf("%-25s %6d %n", " -> Without a Client: "
                , simulationData.getTraineesOnBench().get(type));
        System.out.printf("%-25s %6d %n%n", " -> With Clients: "
                , simulationData.getTraineesWithClient().get(type));

    }

    private static void formatCentrePrint(MappedDTO simulationData, TrainingCentreType type) {

        System.out.printf(" %s %n", type.name() + ": ");
        System.out.printf("%-30s %3d %n", "-> Total Opened: "
                , simulationData.getOpenCentres().get(type));
        System.out.printf("%-30s %n", "   of which, ");
        System.out.printf("%-30s %3d %n", "           Currently Full: "
                , simulationData.getFullCentres().get(type));
        System.out.printf("%-30s %3d %n%n", "           Currently Closed: "
                , simulationData.getClosedCentres().get(type));

    }


    @Override
    public void sendOutput(MappedDTO simulationData) {
        outputToConsole(simulationData);
    }
}
