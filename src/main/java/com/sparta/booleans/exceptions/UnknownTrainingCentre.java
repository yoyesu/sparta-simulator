package com.sparta.booleans.exceptions;

public class UnknownTrainingCentre extends RuntimeException{

    @Override
    public String getMessage() {
        return "Type of Training Centre is unknown!";
    }
}
