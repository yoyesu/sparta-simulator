package com.sparta.booleans.exceptions;

public class NegativeIntInputException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Negative number entered for input, positive number expected";
    }
}
