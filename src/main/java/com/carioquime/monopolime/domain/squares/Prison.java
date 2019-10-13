package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.SquareType;

@Entity
@DiscriminatorValue(value="prison")
public class Prison extends Square 
{

	@Override
	public SquareType getType() {
		return SquareType.PRISON;
	}
	
}
