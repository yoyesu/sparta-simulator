package com.sparta.booLeans.simulator.trainee;

public class Trainee implements TraineeInterface {

    private int TraineeID;
    private boolean isTraining = true;
    private boolean isWaiting = true;
    private String dateCreated;
    private String startTrainingDate;

    @Override
    public int getTraineeID() {
        return TraineeID;
    }

    @Override
    public String getDateCreated() {
        return dateCreated;
    }

    @Override
    public String getStartTrainingDate() {
        return startTrainingDate;
    }

    @Override
    public boolean isTraining(boolean isTraining) {
        this.isTraining=isTraining;
        return isTraining;
    }

    @Override
    public boolean isWaiting(boolean isWaiting) {
        this.isWaiting = isWaiting;
        return isWaiting;
    }

}
