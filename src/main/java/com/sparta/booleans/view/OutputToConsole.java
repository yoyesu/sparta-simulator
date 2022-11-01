package com.sparta.booleans.view;

import com.sparta.booleans.model.DTO;

public class OutputToConsole implements OutputInterface{

    public static void outPutter(int years, int traineeCentre, int totalNumberofTrainees, int fullCentre, int traineesWaiting)
    {
        System.out.println("+-----------------------------------------+");
        System.out.println("Number of years simulation ran for: " + years);
        int months = years*12;
        System.out.println("Number of months simulation ran for: " + months);
        System.out.println("Number of traineeCentres created: " + traineeCentre + " of which " + fullCentre + " are full");
        System.out.println("Number of trainees: " + totalNumberofTrainees);
        System.out.println("Number of trainees waiting: " + traineesWaiting);
        System.out.println("+-----------------------------------------+");


    }

    @Override
    public void sendOutput(DTO simulationData) {

    }
}
