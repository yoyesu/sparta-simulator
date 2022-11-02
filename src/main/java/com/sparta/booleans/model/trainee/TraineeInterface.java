package com.sparta.booleans.model.trainee;

public interface TraineeInterface {

    void setTraineeId(int traineeId);
    int getTraineeId();

    void setMonthCreated(int monthCreated);
    public int getMonthCreated();

    public void setStartTrainingMonth(int startTrainingMonth);
    public int getStartTrainingMonth();

    public boolean isTraining();
    public void setTraining(boolean isTraining);
    public  String getCourseType();
    public void setCourseType(String courseType);

    //Method for how long the trainee is waiting before training?

}
