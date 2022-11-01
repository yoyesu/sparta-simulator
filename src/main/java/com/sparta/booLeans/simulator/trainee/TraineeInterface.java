package com.sparta.booLeans.simulator.trainee;

public interface TraineeInterface {

    void setTraineeId(int traineeId);
    int getTraineeId(int traineeId);

    void setDateCreated();
    String getDateCreated();

    void setIsTraining();
    String getStartTrainingDate();

    boolean isTraining(boolean isTraining);
    void setIsWaiting();

    boolean isWaiting(boolean isWaiting);

    //Method for how long the trainee is waiting before training?

}
