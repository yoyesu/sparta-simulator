package com.sparta.booleans.exceptions;

public class TraineeNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Trainee with that course type could not be found";
    }
}