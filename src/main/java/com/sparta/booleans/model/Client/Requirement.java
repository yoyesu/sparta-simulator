package com.sparta.booleans.model.Client;

import com.sparta.booleans.model.CourseType;

public class Requirement {

    private CourseType requirementType;
    private int numberOfConsultants;


    public CourseType getRequirementType() {
        return requirementType;
    }

    public int getNumberOfConsultants() {
        return numberOfConsultants;
    }


    public Requirement(CourseType requirementType, int numberOfConsultants){
        this.requirementType = requirementType;
        this.numberOfConsultants = numberOfConsultants;
    }

}
