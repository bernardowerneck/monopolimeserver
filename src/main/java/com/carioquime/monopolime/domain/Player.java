package com.carioquime.monopolime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Player 
{
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nick;
	
	private Integer queue;
	
	private Color color;
	
	private Integer money;
	
	private GameSquare currentSquare;
	
	private Game game;
	
	private Boolean isArrested;
	
	private Integer roundsArrested;
	
	private Integer doubleDicesAmount;

	
	//
	// Métodos de acesso
	//
	public Integer getId() {
		return id;
	}

	public String getNick() {
		return nick;
	}

	public Integer getQueue() {
		return queue;
	}

	public Color getColor() {
		return color;
	}

	public Integer getMoney() {
		return money;
	}

	public GameSquare getCurrentSquare() {
		return currentSquare;
	}

	public Game getGame() {
		return game;
	}

	public Boolean getIsArrested() {
		return isArrested;
	}

	public Integer getRoundsArrested() {
		return roundsArrested;
	}

	public Integer getDoubleDicesAmount() {
		return doubleDicesAmount;
	}
	
	
}
