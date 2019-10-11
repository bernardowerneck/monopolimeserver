package com.carioquime.monopolime.domain.squares;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.carioquime.monopolime.domain.Square;


@Entity
@DiscriminatorValue(value="free_pass")
public class FreePass extends Square 
{

}
