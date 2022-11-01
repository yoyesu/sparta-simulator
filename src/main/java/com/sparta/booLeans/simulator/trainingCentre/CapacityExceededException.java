package com.sparta.booLeans.simulator.trainingCentre;

public class CapacityExceededException extends Exception{

    @Override
    public String getMessage() {
        return "Training centre has exceeded its 100 MAX capacity";
    }
}
