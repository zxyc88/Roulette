package com.roulette.roulette.model;

import java.util.List;

public class Information {

    private String dealerName;
    private Integer avgDelta;
    private Integer deltaSD;
    private Integer realDeltaSD;
    private List<Integer> bestNumbers;


    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Integer getAvgDelta() {
        return avgDelta;
    }

    public void setAvgDelta(Integer avgDelta) {
        this.avgDelta = avgDelta;
    }

    public Integer getDeltaSD() {
        return deltaSD;
    }

    public Integer getRealDeltaSD() {
        return realDeltaSD;
    }

    public void setRealDeltaSD(Integer realDeltaSD) {
        this.realDeltaSD = realDeltaSD;
    }

    public void setDeltaSD(Integer deltaSD) {
        if (deltaSD > 6){
            this.deltaSD = 6;
            return;
        }
        this.deltaSD = deltaSD;
    }

    public List<Integer> getBestNumbers() {
        return bestNumbers;
    }

    public void setBestNumbers(List<Integer> bestNumbers) {
        this.bestNumbers = bestNumbers;
    }
}
