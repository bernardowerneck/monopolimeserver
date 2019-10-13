package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.SquareType;

@Entity
@DiscriminatorValue(value="go_to_prision")
public class GoToPrision extends Square
{

	//
	// Métodos de acesso
	//
	@Override
	public SquareType getType() {
		return SquareType.GO_TO_PRISION;
	}

}
