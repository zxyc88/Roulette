package com.roulette.roulette.model;

import javax.persistence.*;

@Entity(name = "view_data")
public class ViewData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @Column(name="start_at")
    private Integer startAt;

    @Column(name="finish_at")
    private Integer finishAt;

    @Column(name="delta")
    private Double delta;

    @Column(name="direction")
    private String direction;

    @Column(name="sd_delta")
    private Double sdDelta;


    public ViewData(){}

    public ViewData(Dealer dealer, Integer startAt)
    {
        this.dealer = dealer;
        this.startAt = startAt;
    }


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

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getSdDelta() {
        return sdDelta;
    }

    public void setSdDelta(Double sdDelta) {
        this.sdDelta = sdDelta;
    }
}
