package com.roulette.roulette.model;

import java.util.List;

public class Table {

    private Dealer dealer;
    private int id;
    private List<Block> hitNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Block> getHitNumbers() {
        return hitNumbers;
    }

    public void setHitNumbers(List<Block> hitNumbers) {
        this.hitNumbers = hitNumbers;
    }
}
