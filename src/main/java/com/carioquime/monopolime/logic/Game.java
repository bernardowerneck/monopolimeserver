package com.carioquime.monopolime.logic;
import java.util.List;

public class Game {
    List<Player> players;
    int gameId;
    public Game(int gameId, List<Player> players){
        this.players = players;
        this.gameId = gameId;
    }
    private boolean isGameRunning(){
        int validPlayers = 0;
        for (Player player: this.players) {
            if(player.money > 0){
                validPlayers++;
            }
        }
        return validPlayers>1;
    }
    private Player findWinner(){
        Player winner = new Player();
        for (Player player: this.players) {
            if(player.money > 0){
                winner = player;
                break;
            }
        }
        return winner;
    }
    void playGame(){
        int turnNumber = 0;
        while(isGameRunning()){
            Player curPlayer = this.players.get(turnNumber);
            Turn newTurn = new Turn();
            newTurn.start(curPlayer, this.players);
            turnNumber++;
            turnNumber %= this.players.size();
        }
        Player winner = this.findWinner();
        warnGameOver(this.players, winner); // Função API para informar aos jogadores do fim do jogo e informar quem venceu
    }


}

//Construtor do player bota money como valor inicial