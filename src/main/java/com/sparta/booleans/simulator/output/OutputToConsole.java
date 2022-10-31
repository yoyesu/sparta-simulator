package com.sparta.booleans.simulator.output;

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
    public void sendOutput() {

    }
}
