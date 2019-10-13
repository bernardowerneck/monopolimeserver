package com.carioquime.monopolime.logic;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        while(true){
            while(!newGameReq()){ // Função da API de dizer se chegou alguma requisição para criar um novo jogo
                continue;
                //BORGES: TROCAR CONTINUE POR SLEEP 1 SEGUNDO PRA NAO SOBRECARREGAR
                // O SERVIDOR, VER COMO FAZER ISSO DA MELHOR FORMA
            }
            int gameId = createNewGameDB(); // Função BD para criar nova partida - retorna ID (int)
            sendIdToFirstPlayer(gameId); // Função API para enviar a UI o Id do jogador administrador
            while(players.size()<6 || !firstPlayerStarted()){ // Função API para informar se o primeiro jogador começou o jogo sem 6 jogadores
                if(isNewPlayerAdded(gameId)){ // Função API para informar se algum jogador novo entrou no jogo
                   Player newPlayer = newPlayerAdded(gameId); // Função API para adicionar novo jogador, retorna objeto da classe Player
                   players.add(newPlayer);
                }
            }
            Game newGame = new Game(gameId, players);
            newGame.playGame();
        }
    }
}
