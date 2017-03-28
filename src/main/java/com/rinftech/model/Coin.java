package com.rinftech.model;

/**
 * Created by Cristian Popovici on 3/12/2017.
 */
public enum Coin {
    ONE_POUND(100),
    FIFTY_PENCE(50),
    TWENTY_PENCE(20),
    TEN_PENCE(10),
    FIVE_PENCE(5),
    TWO_PENCE(2),
    ONE_PENNY(1);

    private int denomination;


    Coin(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }

    @Override
    public String toString() {
        return denomination + " pence";
    }

}
