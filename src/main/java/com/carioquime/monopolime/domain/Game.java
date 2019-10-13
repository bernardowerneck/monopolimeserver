package com.carioquime.monopolime.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game 
{
	//
	// Atributos
	//
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer currentPlayer;
	
	private Integer totalPlayers;

	//
	// Relacionamentos
	//
	@OneToMany
	private List<Player> players;
	
	@OneToMany
	private List<GameSquare> board;
}
