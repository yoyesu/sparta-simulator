package com.sparta.booleans.view;

import com.sparta.booleans.model.DTO;


public class OutputToConsole implements OutputInterface{
    public static void outPutter(DTO simulationData)
    {
        System.out.println("+-----------------------------------------+");
        System.out.println("Number of months simulation ran for: " + simulationData.getTotalMonths());
        System.out.println("Number of traineeCentres created: " + (simulationData.getFullCentres() + simulationData.getOpenCentres()) + " of which " + simulationData.getFullCentres() + " are full");
        System.out.println("Number of trainees: " + simulationData.getTotalTrainees());
        System.out.println("Number of trainees waiting: " + simulationData.getWaitingTrainees());
        System.out.println("+-----------------------------------------+");
    }


    @Override
    public void sendOutput(DTO simulationData) {
        outPutter(simulationData);

    }
}
