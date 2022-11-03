package com.sparta.booleans.exceptions;

public class InvalidIntInputException extends RuntimeException{
    @Override
    public String getMessage() {
        return "There has been an invalid input, simulation does not accept this input";
    }
}
