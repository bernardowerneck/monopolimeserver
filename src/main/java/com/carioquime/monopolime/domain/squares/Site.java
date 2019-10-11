package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;

@Entity
@DiscriminatorValue(value="site")
public class Site extends Square
{
	public Integer valor;
}
