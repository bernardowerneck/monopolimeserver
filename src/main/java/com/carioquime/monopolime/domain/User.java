package com.carioquime.monopolime.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 
{
	@Id
	@GeneratedValue
	public Integer id;
	
	public String nick;
	
	public Integer queue;
	
	public Color color;
}
