package com.carioquime.monopolime.logic;


import java.util.List;


public  class Turn {
    private int getRandomDice(){
        int dice = (int)(Math.random()*6)+1;
        while(dice >= 7 || dice <= 0){
            dice = (int)(Math.random()*6)+1;
        }
        return dice;
    }

    private FieldType fieldAtPlayerPosition(int position){
        if(position == BaseValues.positionFirstGoToPrison || position == BaseValues.positionSecondGoToPrison || position == BaseValues.positionStart){
            return FieldType.specialFields;
        }else if(BaseValues.luckCardPositions.contains(position)){
            return FieldType.luckCard;
        }else if(position == BaseValues.positionPrison){
            return FieldType.prison;
        }else{
            return FieldType.property;
        }
    }

    private boolean playerPassedByStart(Player player, int fieldsMoved){
        return fieldsMoved > player.position;
    }

    private void getNewPosition(Player player, int fieldsMoved){
        player.position = (player.position +fieldsMoved)%BaseValues.numberOfFields;
    }

    private void handleSpecialFields(Player player){
        if(player.position == 7 || player.position == 21){
            player.position = 14;
            player.isOnPrison = true;
        }
    }

    private void handleLuckCard(Player player){
        Card card = new Card();
        card.selectCardFromDB(); // Função do BD para selecionar carta aleatória do Banco de Dados

        if(card.effect == Effects.moveTo){
            getNewPosition(player,card.value);
        }else if(card.effect == Effects.profit){
            player.money += card.value;
        }else{
            player.hasGetOutOfJailCard = true;
        }
    }

    private void handlePrison(Player player, int dice1, int dice2){
        if(playerRollsDice()) { // Função da API para informar se o jogador optou por rolar os dados na prisão
            if(dice1 == dice2) {
                player.isOnPrison = false;
            }
        }else if(playerPaysFee()){ // Função da API para informar se o jogador optou por pagar a multa da prisão
            player.isOnPrison = false;
            player.money -= BaseValues.prisonFee;
        }else{
            player.isOnPrison = false;
            player.hasGetOutOfJailCard = false;
        }
    }

    public void handleProperty(List<Player> players, Player player){
        Property property = getPropertyAtPosition(player.position); // Função do BD para retornar a propriedade na posição que o jogador está
        if(property.ownerId == BaseValues.noOwner){
            if(playerBuysProperty()){ // Função da API para informar se o usuario optou por comprar a propriedade que ele está
                player.properties.add(property);
                property.ownerId = player.playerId;
                player.money -= property.basePrice;
            }

        }else if(property.ownerId != player.playerId){
            player.money -= property.getCurrentValue();
            for(Player player1: players){
                if(player1.playerId == property.ownerId){
                    player1.money += Math.min(property.getCurrentValue(),player.money);
                    break;
                }
            }
        }else{
            if(playerHasAllProperties()){
                property.numHouses++;
                player.money -= BaseValues.priceHouse;
            }else if(playerHasThreeHousesInAllProperties()){
                property.numHotels++;
                player.money -= BaseValues.priceHotel;
            }
        }
    }

    public void start(Player cur_player, List<Player> players){
        if(cur_player.money<=0) {
            return;
        }
        notifyPlayers(players);
        int dice1 = this.getRandomDice();
        int dice2 = this.getRandomDice();
        sendDiceResult(cur_player, dice1, dice2); // Função da API para informar a UI quais os valores dos dados obtido
        //bota um time out pra ver se o usuario foi desconectado
        if(cur_player.isOnPrison){
            handlePrison(cur_player, dice1, dice2);
        }
        else{
            getNewPosition(cur_player, dice1+dice2);
            if(playerPassedByStart(cur_player, dice1+dice2)){
                cur_player.money += BaseValues.startMoney;
            }
            notifyPlayer(cur_player); // Função da API para notificar a UI a nova posição e o novo saldo do jogador
            if(fieldAtPlayerPosition(cur_player.position) == FieldType.property){
                handleProperty(players, cur_player);
            }else if(fieldAtPlayerPosition(cur_player.position) == FieldType.luckCard){
                handleLuckCard(cur_player);
            }else{
                handleSpecialFields(cur_player);
            }
        }
        if(cur_player.money <= 0){
            for(Property property: cur_player.properties){
                property.ownerId = BaseValues.noOwner;
            }
            cur_player.properties.clear();
        }
        notifyPlayers(players); // Função da API para informar as novas informações de todos os jogadores
        saveTurn(cur_player,players); // Função do BD para salvar todos os dados dos jogadores no banco de dados
        return;
    }
}
