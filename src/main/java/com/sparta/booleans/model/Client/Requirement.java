package com.sparta.booleans.model.Client;

import com.sparta.booleans.model.CourseType;

public class Requirement {

    // Fields
    private CourseType requirementType;
    private int numberOfConsultants;
    private int traineesVacancies;
    private int requirementID;
    private int monthCreated;

    // Getters
    public CourseType getRequirementType() {return requirementType;}
    public int getNumberOfConsultants()    {return numberOfConsultants;}
    public int getTraineesVacancies()      {return traineesVacancies;}
    public int getRequirementID()          {return requirementID;}

    // Constructor
    public Requirement(CourseType requirementType, int numberOfConsultants, int requirementID, int monthCreated){

        this.requirementType     = requirementType;
        this.numberOfConsultants = numberOfConsultants;
        this.traineesVacancies   = numberOfConsultants;
        this.requirementID       = requirementID;
        this.monthCreated        = monthCreated;
    }

    // Methods
    public void reduceAvailableSpace() {
        traineesVacancies--;
    }
}
