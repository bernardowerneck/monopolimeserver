package com.carioquime.monopolime.logic;


public class Property {
    int numHouses;
    int numHotels;
    int basePrice;
    ColorType color;
    int ownerId;

    Property(){
        this.ownerId = BaseValues.noOwner;
    }

    public int getCurrentValue(){
        return basePrice + BaseValues.houseMultiplier*numHouses + BaseValues.hotelsMultiplier*numHotels;
    }

}
