package com.roulette.roulette.model;

import java.util.List;

public class Table {

    private int id;
    private List<Block> blocks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
