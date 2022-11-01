package com.sparta.booleans.exceptions;

public class CapacityExceededException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Training centre has exceeded its 100 MAX capacity";
    }
}
