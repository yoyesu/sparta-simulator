package com.sparta.booleans.model.trainee;

import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.utility.random.Randomizer;

public class Trainee implements TraineeInterface {

    private int traineeId;
    private boolean isTraining;
    private int monthCreated;
    private int startTrainingMonth;

    private CourseType courseType;


    public Trainee(int traineeId, int monthCreated) {
        this.traineeId = traineeId;
        this.monthCreated = monthCreated;
        this.isTraining = false;
        this.startTrainingMonth = -1;
        this.courseType = Randomizer.generateCourse();
    }

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

    public CourseType getCourseType() { return courseType;}

    @Override
    public void setCourseType(String courseType) {
        
    }

    public void setCourseType(CourseType courseType) {this.courseType = courseType;}
}
