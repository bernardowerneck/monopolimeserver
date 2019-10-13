package com.carioquime.monopolime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carioquime.monopolime.domain.Square;
import com.carioquime.monopolime.domain.squares.Chance;
import com.carioquime.monopolime.domain.squares.FreePass;
import com.carioquime.monopolime.domain.squares.Prison;
import com.carioquime.monopolime.domain.squares.Site;
import com.carioquime.monopolime.domain.squares.Start;

public class MonopolimeApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgreSQLPersistence");
		EntityManager em = emf.createEntityManager();
		
		Square sqr1 = new Site();
		sqr1.description="site";
		
		Square sqr2 = new Start();
		sqr2.description="start";
		
		Square sqr3 = new Chance();
		sqr3.description="chance";

		Square sqr4 = new FreePass();
		sqr4.description="free pass";
		
		Square sqr5 = new Prison();
		sqr5.description="prision";
		
		em.persist(sqr1);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.persist(sqr2);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.persist(sqr3);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.persist(sqr4);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.persist(sqr5);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		emf.close();
	}

}
