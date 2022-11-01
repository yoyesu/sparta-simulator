package com.sparta.booLeans.simulator;

public class CapacityExceededException extends Exception{

    @Override
    public String getMessage() {
        return "Training centre has exceeded its 100 MAX capacity";
    }
}
