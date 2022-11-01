package com.sparta.booLeans.simulator.Input;

import java.util.Scanner;

//how many years and dates they want

public class TimeFrameInputter implements Inputable{
    //how many years and dates they want
    @Override
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 1) {
            System.out.println("Invalid input");
            input = scanner.nextInt();
        }
        return input;
    }

    @Override
    public int getTotalMonths()
    {
        return getMonths() + (getYears()*12);
    }

    private int getYears() {
        System.out.println("Enter the number of years: ");
        return getInputInt();
    }

    private int getMonths(){
        System.out.println("Enter the number of months: ");
        return getInputInt();
    }
}
