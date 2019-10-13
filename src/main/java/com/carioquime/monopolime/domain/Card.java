package com.carioquime.monopolime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card 
{
	//
	// Atributos
	//
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	private Integer value;
	
	private Boolean isLuck;

	//
	// Métodos de acesso
	//
	public String getDescription() {
		return description;
	}

	public Integer getValue() {
		return value;
	}

	public Boolean getIsLuck() {
		return isLuck;
	}
}
