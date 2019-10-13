package com.carioquime.monopolime.logic;


import java.util.List;

public class Player {
    // Falta fazer construtor e algumas outras coisas @Werneck
    boolean isOnPrison;
    boolean hasGetOutOfJailCard;
    int playerId;
    int position;
    int money;
    List<Property> properties;

    Player(){
        this.hasGetOutOfJailCard = false;
        this.isOnPrison = false;
    }

}
