package com.sparta.booleans.model.Client;

import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.utility.random.Randomizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Client {

    ArrayList<Requirement> requiredSkills;
    private ArrayList<Trainee> traineesAssigned;
    private int clientID;
    private int monthCreated;
    private boolean isActive;

    //getters for client
    public int getClientID()     {return clientID;}
    public int getMonthCreated() {return monthCreated;}
    public boolean isActive()    {return isActive;}

    Client (int clientID, int monthCreated) {
        this.clientID = clientID;
        this.monthCreated = monthCreated;
        isActive = true;
        requiredSkills = new ArrayList<>();
        traineesAssigned = new ArrayList<>();
    }

    private void generateRequirement(int requirementID, int monthCreated, int bound) {

        Random random = new Random();
        int clientTraineesRequired = random.nextInt(15,bound);

        Requirement requirement = new Requirement(Randomizer.generateCourse(),
                                clientTraineesRequired,
                                                  requirementID,
                                                  monthCreated);
        requiredSkills.add(requirement);
    }

    public boolean shouldLeave() {

        int totalVacancies = 0;

        for(int i = 0; i < requiredSkills.size(); i++)
            totalVacancies += requiredSkills.get(i).getTraineesVacancies();

        if(traineesAssigned.size() < totalVacancies) {
            isActive = false;
            return true;
        }
        return false;
    }

    public ArrayList <Trainee>     getTraineesAssigned() {return new ArrayList<>(traineesAssigned);}
    public ArrayList <Requirement> getRequiredSkills()   {return requiredSkills;}

    public void assignTrainee(Trainee trainee) {

        traineesAssigned.add(trainee);
    }
}
