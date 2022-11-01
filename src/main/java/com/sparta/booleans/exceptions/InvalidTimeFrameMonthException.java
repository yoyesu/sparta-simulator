package com.sparta.booleans.exceptions;

public class InvalidTimeFrameMonthException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Invalid time entered, max months is 11";
    }

}
