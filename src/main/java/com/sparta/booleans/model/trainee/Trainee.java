package com.sparta.booleans.model.trainee;

public class Trainee implements TraineeInterface {

    private int traineeId;
    private boolean isTraining;
    private int monthCreated;
    private int startTrainingMonth;

@Override
    public void setTraineeId(int traineeId) {
        this.traineeId= traineeId;
    }

    @Override
    public int getTraineeId() {
        return traineeId;
    }

    @Override
    public boolean isTraining() {
        return isTraining;
    }
@Override
    public void setTraining(boolean isTraining) {
        this.isTraining = isTraining;
    }

    @Override
    public int getMonthCreated() {
        return monthCreated;
    }
@Override
    public void setMonthCreated(int monthCreated) {
        this.monthCreated = monthCreated;
    }

    @Override
    public int getStartTrainingMonth() {
        return startTrainingMonth;
    }
@Override
    public void setStartTrainingMonth(int startTrainingMonth) {
        this.startTrainingMonth = startTrainingMonth;
    }

}
