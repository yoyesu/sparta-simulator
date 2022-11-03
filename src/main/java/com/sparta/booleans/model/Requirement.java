package com.sparta.booleans.model;

public class Requirement {

    private CourseType requirementType;
    private int numberOfConsultants;

    public Requirement(CourseType requirementType, int numberOfConsultants){
        this.requirementType = requirementType;
        this.numberOfConsultants = numberOfConsultants;
    }

    public CourseType getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(CourseType requirementType) {
        this.requirementType = requirementType;
    }

    public int getNumberOfConsultants() {
        return numberOfConsultants;
    }

    public void setNumberOfConsultants(int numberOfConsultants) {
        this.numberOfConsultants = numberOfConsultants;
    }

}
