package com.roulette.roulette.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class ViewData {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Dealer dealer;
    private Integer startAt;
    private Integer finishAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Integer getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Integer finishAt) {
        this.finishAt = finishAt;
    }
}
