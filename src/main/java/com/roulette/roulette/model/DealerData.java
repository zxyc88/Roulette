package com.roulette.roulette.model;

public class DealerData {

    private int id;
    private Dealer dealer;
    private Block start;
    private Block end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Block getStart() {
        return start;
    }

    public void setStart(Block start) {
        this.start = start;
    }

    public Block getEnd() {
        return end;
    }

    public void setEnd(Block end) {
        this.end = end;
    }
}
