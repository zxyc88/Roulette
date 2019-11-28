package com.roulette.roulette.model;

import java.util.ArrayList;


public class RouletteWheel {

    private final static ArrayList<Integer> theWheel = new ArrayList<>();

    public RouletteWheel(){
        theWheel.add(37);
        theWheel.add(27);
        theWheel.add(10);
        theWheel.add(25);
        theWheel.add(29);
        theWheel.add(12);
        theWheel.add(8);
        theWheel.add(19);
        theWheel.add(31);
        theWheel.add(18);
        theWheel.add(6);
        theWheel.add(21);
        theWheel.add(33);
        theWheel.add(16);
        theWheel.add(4);
        theWheel.add(23);
        theWheel.add(35);
        theWheel.add(14);
        theWheel.add(2);
        theWheel.add(0);
        theWheel.add(28);
        theWheel.add(9);
        theWheel.add(26);
        theWheel.add(30);
        theWheel.add(11);
        theWheel.add(7);
        theWheel.add(20);
        theWheel.add(32);
        theWheel.add(17);
        theWheel.add(5);
        theWheel.add(22);
        theWheel.add(34);
        theWheel.add(15);
        theWheel.add(3);
        theWheel.add(24);
        theWheel.add(36);
        theWheel.add(13);
        theWheel.add(1);
    }

    public static ArrayList<Integer> getTheWheel() {
        return theWheel;
    }

    public int getWheelIndex(Integer number){
        return theWheel.indexOf(number);
    }

    public int getWheelNumber(Integer number){
        return theWheel.get(number);
    }
}
