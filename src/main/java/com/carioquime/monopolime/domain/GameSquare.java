package com.carioquime.monopolime.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_square")
public class GameSquare 
{
	//
	// Relacionamentos
	//
	@OneToOne
	private Square square;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Player owner;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	//
	// Métodos de acesso
	// 
	public SquareType getType() {
		return square.getType();
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Square getSquare() {
		return square;
	}
	
	
}
