package com.roulette.roulette.model;

import static com.roulette.roulette.model.Colour.BLACK;
import static com.roulette.roulette.model.Colour.RED;
import static com.roulette.roulette.model.Colour.GREEN;

public class Block extends RouletteWheel{

        private String number;
        private Colour colour;

    public Block(String number){
        this.number =  number;
        if (number.equals("2") || number.equals("4") || number.equals("6")  || number.equals("8")  || number.equals("10")  || number.equals("11")  || number.equals("13")
                || number.equals("15")  || number.equals("17")  || number.equals("20")  || number.equals("22")  || number.equals("24")  || number.equals("26")  || number.equals("28")
                || number.equals("29")  || number.equals("31")  || number.equals("33")  || number.equals("35")){
            this.colour = BLACK;
        }
        else if (number.equals("1") || number.equals("3") || number.equals("5")  || number.equals("7")  || number.equals("9")  || number.equals("12")  || number.equals("14")
                || number.equals("16")  || number.equals("18")  || number.equals("19")  || number.equals("21")  || number.equals("23")  || number.equals("25")  || number.equals("27")
                || number.equals("30")  || number.equals("32")  || number.equals("34")  || number.equals("36")){
            this.colour = RED;
        }
        else
        {
            this.colour = GREEN;
        }
    }

    public Block(String number, Colour colour){
        this.number = number;
        this.colour = colour;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
