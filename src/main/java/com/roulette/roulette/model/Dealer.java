package com.roulette.roulette.model;

public class Dealer {

    private String name;
    private int startTime;
    private int endTime;
    private int breakTime;

    public int inTheZone() {
        //Method to return the time that is best to Bet and Dealer is IN THE ZONE
        return 0;
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
