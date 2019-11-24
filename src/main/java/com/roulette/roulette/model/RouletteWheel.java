package com.roulette.roulette.model;

import java.util.ArrayList;

import static com.roulette.roulette.model.Colour.GREEN;
import static com.roulette.roulette.model.Colour.RED;
import static com.roulette.roulette.model.Colour.BLACK;


public class RouletteWheel {

    private final static ArrayList<Block> wheelNumbers = new ArrayList<>();

    public RouletteWheel(){
        wheelNumbers.add(new Block("00"));
        wheelNumbers.add(new Block("27"));
        wheelNumbers.add(new Block("10"));
        wheelNumbers.add(new Block("25"));
        wheelNumbers.add(new Block("29"));
        wheelNumbers.add(new Block("12"));
        wheelNumbers.add(new Block("8"));
        wheelNumbers.add(new Block("19"));
        wheelNumbers.add(new Block("31"));
        wheelNumbers.add(new Block("18"));
        wheelNumbers.add(new Block("6"));
        wheelNumbers.add(new Block("21"));
        wheelNumbers.add(new Block("33"));
        wheelNumbers.add(new Block("16"));
        wheelNumbers.add(new Block("4"));
        wheelNumbers.add(new Block("23"));
        wheelNumbers.add(new Block("35"));
        wheelNumbers.add(new Block("14"));
        wheelNumbers.add(new Block("2"));
        wheelNumbers.add(new Block("0"));
        wheelNumbers.add(new Block("28"));
        wheelNumbers.add(new Block("9"));
        wheelNumbers.add(new Block("26"));
        wheelNumbers.add(new Block("30"));
        wheelNumbers.add(new Block("11"));
        wheelNumbers.add(new Block("7"));
        wheelNumbers.add(new Block("20"));
        wheelNumbers.add(new Block("32"));
        wheelNumbers.add(new Block("17"));
        wheelNumbers.add(new Block("5"));
        wheelNumbers.add(new Block("22"));
        wheelNumbers.add(new Block("34"));
        wheelNumbers.add(new Block("15"));
        wheelNumbers.add(new Block("3"));
        wheelNumbers.add(new Block("24"));
        wheelNumbers.add(new Block("36"));
        wheelNumbers.add(new Block("13"));
        wheelNumbers.add(new Block("1"));
    }

    public static ArrayList<Block> getWheelNumbers() {
        return wheelNumbers;
    }
}
