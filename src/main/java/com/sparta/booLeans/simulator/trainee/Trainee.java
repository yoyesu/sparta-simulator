package com.sparta.booLeans.simulator.trainee;

public class Trainee implements TraineeInterface {

    private int traineeID;
    private boolean isTraining;
    private boolean isWaiting;
    private int monthCreated;
    private int startTrainingMonth;


    @Override
    public void setTraineeId(int traineeId) {
        this.traineeID=traineeId;
    }

    @Override
    public int getTraineeId(int traineeId) {
        return traineeID;
    }

    @Override
    public void setMonthCreated() {
        this.monthCreated=monthCreated;
    }

    @Override
    public int getMonthCreated() {
        return monthCreated;
    }

    @Override
    public void setIsTraining() {
        this.isTraining=isTraining;
    }

    @Override
    public int getStartTrainingMonth() {
        return startTrainingMonth;
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
