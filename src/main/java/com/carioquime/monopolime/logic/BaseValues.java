package com.carioquime.monopolime.logic;

import java.util.ArrayList;
import java.util.List;

public class BaseValues {
    static int startMoney = 200;
    static int positionFirstGoToPrison = 7;
    static int positionSecondGoToPrison = 14;
    static int positionPrison = 21;
    static int positionStart = 0;
    static int priceHouse = 100;
    static int priceHotel = 500;
    static int numberOfFields = 28;
    static int noOwner = -1;
    static int prisonFee = 50;
    static int houseMultiplier = 200;
    static int hotelsMultiplier = 1000;

    static List<Integer> luckCardPositions = new ArrayList<Integer>() {{
        add(2);
        add(5);
        add(10);
        add(12);
        add(16);
        add(19);
        add(24);
        add(26);
    }};;

}
