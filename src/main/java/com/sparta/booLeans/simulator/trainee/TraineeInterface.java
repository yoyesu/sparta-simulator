package com.sparta.booLeans.simulator.trainee;

public interface TraineeInterface {

    int getTraineeID();

    String getDateCreated();

    String getStartTrainingDate();

    boolean isTraining(boolean isTraining);

    boolean isWaiting(boolean isWaiting);

    //Method for how long the trainee is waiting before training?

}
