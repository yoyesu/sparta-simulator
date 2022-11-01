package com.sparta.booleans.view.input;

import java.util.Scanner;

//how many years and dates they want

public class TimeFrameInputter implements Inputable{
    //how many years and dates they want
    @Override
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 0) {
            System.out.println("Invalid input");
            input = scanner.nextInt();
        }
        return input;
    }

    @Override
    public int getTotalMonths()
    {
        System.out.println("Enter Years and months for simulation");
        return  (getYears()*12) + getMonths();
    }

    public int getTotalMonths(int years, int months)
    {
        System.out.println("Enter Years and months for simulation");
        return  (years * 12) + months;
    }

    private int getYears() {
        System.out.println("Enter the number of years: ");
        return getInputInt();
    }

    private int getMonths(){
        System.out.println("Enter the number of months: ");
        int input = 99;
        while (input > 11) {
            System.out.println("Maximum number of months is 11");
            input = getInputInt();
        }return input;

    }
}
