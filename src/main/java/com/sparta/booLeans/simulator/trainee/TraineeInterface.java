package com.sparta.booLeans.simulator.trainee;

public interface TraineeInterface {

    void setTraineeId(int traineeId);
    int getTraineeId();

    void setMonthCreated(int monthCreated);
    public int getMonthCreated();

    public void setStartTrainingMonth(int startTrainingMonth);
    public int getStartTrainingMonth();

    public boolean isTraining();
    public void setTraining(boolean isTraining);

    //Method for how long the trainee is waiting before training?

}
