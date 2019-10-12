package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.SquareType;

@Entity
@DiscriminatorValue(value="site")
public class Site extends Square
{
	public Integer valor;

	@Override
	public SquareType getType() {
		return SquareType.SITE;
	}
}
