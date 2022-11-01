package com.sparta.booLeans.simulator.trainee;

public class Trainee implements TraineeInterface {

    private int TraineeID;
    private boolean isTraining = false;
    private boolean isWaiting = false;

    @Override
    public int getTraineeID() {
        return 0;
    }

    @Override
    public String getDateCreated() {
        return null;
    }

    @Override
    public String getStartTrainingDate() {
        return null;
    }

    @Override
    public boolean isTraining(boolean isTraining) {
        return false;
    }

    @Override
    public boolean isWaiting(boolean isWaiting) {
        return false;
    }

}
