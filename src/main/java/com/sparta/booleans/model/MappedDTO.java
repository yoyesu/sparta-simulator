package com.sparta.booleans.model;

import java.util.HashMap;

public class MappedDTO {

    // Number of months the simulation has run for
    private int totalMonths;

    // Number of trainees in the waiting list by type
    HashMap<CourseType, Integer> traineesWaiting;

    // Number of trainees currently training by type
    HashMap<CourseType, Integer> traineesTraining;

    // Number of trainees finished training and on the bench by type
    HashMap<CourseType, Integer> traineesOnBench;

    // Number of trainees finished training and working with a client by type
    HashMap<CourseType, Integer> traineesWithClient;

    // Number of centres open during simulation by type
    HashMap<TrainingCentreType, Integer> openCentres;

    // Number of centres closed during simulation by type
    HashMap<TrainingCentreType, Integer> closedCentres;

    // Number of centres which are at full capacity after simulation by type
    HashMap<TrainingCentreType, Integer> fullCentres;

    // Number of clients that have had their needs met
    int happyClients;

    // Number of clients that haven't had their needs met and left
    int unhappyClients;


    public MappedDTO(int totalMonths, HashMap<CourseType, Integer> traineesWaiting,
                     HashMap<CourseType, Integer> traineesTraining, HashMap<CourseType, Integer> traineesOnBench,
                     HashMap<CourseType, Integer> traineesWithClient, HashMap<TrainingCentreType, Integer> openCentres,
                     HashMap<TrainingCentreType, Integer> closedCentres,
                     HashMap<TrainingCentreType, Integer> fullCentres, int happyClients, int unhappyClients) {
        this.totalMonths = totalMonths;
        this.traineesWaiting = traineesWaiting;
        this.traineesTraining = traineesTraining;
        this.traineesOnBench = traineesOnBench;
        this.traineesWithClient = traineesWithClient;
        this.openCentres = openCentres;
        this.closedCentres = closedCentres;
        this.fullCentres = fullCentres;
        this.happyClients = happyClients;
        this.unhappyClients = unhappyClients;
    }

    public int getTotalMonths() {
        return totalMonths;
    }

    public HashMap<CourseType, Integer> getTraineesWaiting() {
        return traineesWaiting;
    }

    public HashMap<CourseType, Integer> getTraineesTraining() {
        return traineesTraining;
    }

    public HashMap<CourseType, Integer> getTraineesOnBench() {
        return traineesOnBench;
    }

    public HashMap<CourseType, Integer> getTraineesWithClient() {
        return traineesWithClient;
    }

    public HashMap<TrainingCentreType, Integer> getOpenCentres() {
        return openCentres;
    }

    public HashMap<TrainingCentreType, Integer> getClosedCentres() {
        return closedCentres;
    }

    public HashMap<TrainingCentreType, Integer> getFullCentres() {
        return fullCentres;
    }

    public int getHappyClients() {
        return happyClients;
    }

    public int getUnhappyClients() {
        return unhappyClients;
    }
}
