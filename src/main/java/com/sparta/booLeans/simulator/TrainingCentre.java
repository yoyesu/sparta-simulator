package com.sparta.booLeans.simulator;

import java.util.ArrayList;
import java.util.Date;

public class TrainingCentre {

    // Fields
    private int capacity;
    private int centreID;
    private Date dateCreated;
    private int monthlyIntake;
    public ArrayList <Integer> currentTrainees;

    // Constructor
    public TrainingCentre() {

        capacity = 100;
        currentTrainees = new ArrayList<>();
    }

    // Getters
    public int  getCapacity()      {return capacity;}
    public int  getCentreID()      {return centreID;}
    public Date getDateCreated()   {return dateCreated;}
    public int  getMonthlyIntake() {return monthlyIntake;}

    // Setters
    public void setCapacity(int capacity)           {this.capacity = capacity;}
    public void setCentreID(int centreID)           {this.centreID = centreID;}
    public void setDateCreated(Date dateCreated)    {this.dateCreated = dateCreated;}
    public void setMonthlyIntake(int monthlyIntake) {this.monthlyIntake = monthlyIntake;}

    // Methods
    public boolean isFull() {

        return currentTrainees.size() == capacity;
    }
}
