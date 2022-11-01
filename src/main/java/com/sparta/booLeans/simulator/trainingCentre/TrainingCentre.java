package com.sparta.booLeans.simulator.trainingCentre;

import com.sparta.booLeans.simulator.trainee.Trainee;
import java.util.ArrayList;

public class TrainingCentre {

    // Fields
    private final int capacity;
    private final int centreID;
    private final int dateCreated;
    private int monthlyIntake;
    private ArrayList <Trainee> currentTrainees;

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
        CapacityExceededException capacityExceededException = new CapacityExceededException();
        if (currentTrainees.size() > capacity) {

            currentTrainees.remove(101);
            throw capacityExceededException;
        }
    }
}
