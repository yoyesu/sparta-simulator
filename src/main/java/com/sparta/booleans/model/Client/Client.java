package com.sparta.booleans.model.Client;

import com.sparta.booleans.model.trainee.Trainee;
import com.sparta.booleans.utility.random.Randomizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Client {

    HashSet<Requirement> requiredSkills;
    ArrayList<Trainee> traineesAssigned;
    private int clientID;
    private int monthCreated;
    private boolean isActive;

    //getters for client
    public int getClientID() {
        return clientID;
    }

    public int getMonthCreated() {return monthCreated;}

    public boolean isActive() {return isActive;}

    Client (int clientID, int monthCreated) {
        this.clientID = clientID;
        this.monthCreated = monthCreated;
        isActive = true;
        requiredSkills = new HashSet<>();
        traineesAssigned = new ArrayList<>();
    }

    public Requirement generateRequirement() {

        Random random = new Random();
        int clientTraineesRequired = random.nextInt(15,101);

        Requirement requirement = new Requirement(Randomizer.generateCourse(),clientTraineesRequired);
        return requirement;
    }

    public boolean shouldLeave () {
        return false;
    }
}
