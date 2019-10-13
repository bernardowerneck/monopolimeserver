package com.carioquime.monopolime.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="square")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Square 
{
	
	//
	// Atributos
	//
	@Id
	@GeneratedValue
	private Integer position;
	
	private String description;

	//
	// Métodos de acesso
	// 
	public Integer getPosition() {
		return position;
	}

	public String getDescription() {
		return description;
	}

	public abstract SquareType getType();
	
}
