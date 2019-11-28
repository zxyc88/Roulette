package com.roulette.roulette.model;

import java.util.List;

public class Information {

    private String dealerName;
    private Integer delta;
    private Integer deltaSD;
    private List<Integer> bestNumbers;


    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public Integer getDeltaSD() {
        return deltaSD;
    }

    public void setDeltaSD(Integer deltaSD) {
        this.deltaSD = deltaSD;
    }

    public List<Integer> getBestNumbers() {
        return bestNumbers;
    }

    public void setBestNumbers(List<Integer> bestNumbers) {
        this.bestNumbers = bestNumbers;
    }
}
