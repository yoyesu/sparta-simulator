package com.sparta.booleans.view.input;

import com.sparta.booleans.exceptions.InvalidTimeFrameMonthException;
import com.sparta.booleans.exceptions.NegativeIntInputException;

import java.util.Scanner;

//how many years and dates they want

public class TimeFrameInputter implements Inputable{
    //how many years and dates they want
    @Override
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        try{
            input = scanner.nextInt();
            if(input < 0){
                throw new NegativeIntInputException();
            }
        }catch (NegativeIntInputException e){
            System.out.println(e.getMessage());
            System.out.println("Re-enter a number: ");
            input = getInputInt();
        }
        return input;
    }

    @Override
    public int getTotalMonths() {
        System.out.println("Enter Years and months for simulation");
        return  (getYears()*12) + getMonths();
    }

    public int getTotalMonths(int years, int months) {
        System.out.println("Enter Years and months for simulation");
        return  (years * 12) + months;
    }

    private int getYears() {
        System.out.println("Enter the number of years: ");
        return getInputInt();
    }

    private int getMonths() throws InvalidTimeFrameMonthException {
        System.out.println("Enter the number of months: ");
        int input = 999;
        try{
            input = getInputInt();
            if(input > 11) {
                throw new InvalidTimeFrameMonthException();
            }
        }catch (InvalidTimeFrameMonthException e){
            System.out.println(e.getMessage());
            input = getMonths();
        }
        return input;

    }
}
