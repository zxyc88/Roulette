package com.roulette.roulette.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Dealer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int startTime;
    private int endTime;
    private int breakTime;

    public int inTheZone() {
        //Method to return the time that is best to Bet and Dealer is IN THE ZONE
        //Optimal time for dealer to heat up and get in their rhythm but still far from a break or end of shift
        return 0;
    }

    public Dealer (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }
}
