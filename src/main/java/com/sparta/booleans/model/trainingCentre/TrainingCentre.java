package com.sparta.booleans.model.trainingCentre;

import com.sparta.booleans.exceptions.CapacityExceededException;
import com.sparta.booleans.model.trainee.Trainee;
import java.util.ArrayList;

public abstract class TrainingCentre {

    // Fields
    protected int capacity;
    protected final int centreID;
    protected final int dateCreated;
    protected int monthlyIntake;
    protected ArrayList <Trainee> currentTrainees;

    // Constructor
    public TrainingCentre(int dateCreated, int centreID, int monthlyIntake) {

        this.dateCreated = dateCreated;
        this.capacity = 100;
        this.currentTrainees = new ArrayList<>();
        this.centreID = centreID;
        this.monthlyIntake = monthlyIntake;
    }
    public TrainingCentre(int dateCreated, int centreID) {

        this.dateCreated = dateCreated;
        this.capacity = 100;
        this.currentTrainees = new ArrayList<>();
        this.centreID = centreID;
    }

    // Getters
    public int getCentreID()       {return centreID;}
    public int getDateCreated()    {return dateCreated;}
    public int getMonthlyIntake()  {return monthlyIntake;}
    public ArrayList <Trainee> getCurrentTrainees() {

        return new ArrayList<>(currentTrainees);
    }

    // Setters
    public void setMonthlyIntake (int monthlyIntake) {this.monthlyIntake = monthlyIntake;}

    // Methods
    public boolean isFull() {

        return currentTrainees.size() == capacity;
    }

    public int getVacancies() {

        return capacity - currentTrainees.size();
    }

    public void addTrainee(Trainee trainee) throws CapacityExceededException {

        currentTrainees.add(trainee);
        monthlyIntake--;

        if (currentTrainees.size() > capacity) {

            currentTrainees.remove(100);
            throw new CapacityExceededException();
        }
    }

    public int openHowLong(int currentMonth) {

        return currentMonth - dateCreated;
    }

    abstract boolean shouldBeClosed();
}
