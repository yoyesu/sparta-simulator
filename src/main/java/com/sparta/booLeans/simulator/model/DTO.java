package com.sparta.booleans.simulator.model;

/*
This Data Transfer Object holds the data gathered during simulation.
 */
public class DTO {

    // Number of centres which are at full capacity after simulation
    private int fullCentres;

    // Number of trainees created during
    private int totalTrainees;

    // Number of trainees in the waiting list
    private int waitingTrainees;

    // NUmber of months the simulation has run for
    private int totalMonths;
    // Number of centres open during simulation
    private int openCentres;


    public int getFullCentres() {
        return fullCentres;
    }

    public void setFullCentres(int fullCentres) {
        this.fullCentres = fullCentres;
    }

    public int getTotalTrainees() {
        return totalTrainees;
    }

    public void setTotalTrainees(int totalTrainees) {
        this.totalTrainees = totalTrainees;
    }

    public int getWaitingTrainees() {
        return waitingTrainees;
    }

    public void setWaitingTrainees(int waitingTrainees) {
        this.waitingTrainees = waitingTrainees;
    }

    public int getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(int totalMonths) {
        this.totalMonths = totalMonths;
    }


    public int getOpenCentres() {
        return openCentres;
    }

    public void setOpenCentres(int openCentres) {
        this.openCentres = openCentres;
    }
}
