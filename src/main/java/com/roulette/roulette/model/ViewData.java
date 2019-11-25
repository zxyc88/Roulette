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
