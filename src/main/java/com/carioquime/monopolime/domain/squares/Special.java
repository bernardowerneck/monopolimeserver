package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.SquareType;

@Entity
@DiscriminatorValue(value="special")
public class Special extends Square
{

	@Override
	public SquareType getType() {

		return SquareType.SPECIAL;
	}
	
}
