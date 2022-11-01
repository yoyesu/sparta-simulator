package com.sparta.booLeans.simulator.trainee;

public class Trainee implements TraineeInterface {

    private int traineeID;
    private boolean isTraining;
    private boolean isWaiting;
    private String dateCreated;
    private String startTrainingDate;


    @Override
    public void setTraineeId(int traineeId) {
        this.traineeID=traineeId;
    }

    @Override
    public int getTraineeId(int traineeId) {
        return traineeID;
    }

    @Override
    public void setDateCreated() {
        this.dateCreated=dateCreated;
    }

    @Override
    public String getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setIsTraining() {
        this.isTraining=isTraining;
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
    public void setIsWaiting() {
        this.isWaiting = isWaiting;
    }

    @Override
    public boolean isWaiting(boolean isWaiting) {
        return isWaiting;
    }

}
