package com.example.grammar.enums.enums;

public enum Coin {

    penny("penny"), nickel("nickel"), dime("dime"), quarter("quarter");

    private String value;

    public String getValue() {
        return value;
    }

    Coin(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Coin coin = Coin.quarter;
        System.out.println(coin.getValue());
    }
}
