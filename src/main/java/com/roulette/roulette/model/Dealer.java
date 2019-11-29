package com.roulette.roulette.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dealers")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public int inTheZone() {
        //Method to return the time that is best to Bet and Dealer is IN THE ZONE
        //Optimal time for dealer to heat up and get in their rhythm but still far from a break or end of shift
        return 0;
    }

    public Dealer (){
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

}
