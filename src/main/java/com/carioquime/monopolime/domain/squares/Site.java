package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.SquareType;

@Entity
@DiscriminatorValue(value="site")
public class Site extends Square
{
	//
	// Atributos
	//
	private Integer valor;

	//
	// Métodos de acesso
	//
	@Override
	public SquareType getType() {
		return SquareType.SITE;
	}

	public Integer getValor() {
		return valor;
	}
	
}
