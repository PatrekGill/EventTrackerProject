package com.skilldistillery.mygamelist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.mygamelist.compositeids.GameRelationId;

class GameRelationTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private GameRelationId relationId;
	private GameRelation gameRelation;
	private Game primaryGame;
	private Game otherGame;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAGameList");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		primaryGame = new Game(1);
		otherGame = new Game(2);
		relationId = new GameRelationId(primaryGame,otherGame);

		em = emf.createEntityManager();
		gameRelation = em.find(GameRelation.class, relationId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		
		primaryGame = null;
		otherGame = null;
		relationId = null;
		gameRelation = null;
	}

	
	@Test
	void test_GameRelation_primaryGame_mapping() {
		assertNotNull(gameRelation);
		assertNotNull(gameRelation.getPrimaryGame());
		assertEquals("Mass Effect", gameRelation.getPrimaryGame().getTitle());
	}
	
	@Test
	void test_GameRelation_otherGame_mapping() {
		assertNotNull(gameRelation);
		assertNotNull(gameRelation.getPrimaryGame());
		assertEquals("Mass Effect 2", gameRelation.getOtherGame().getTitle());
	}
	
	@Test
	void test_GameRelation_relationship_mapping() {
		assertNotNull(gameRelation);
		assertNotNull(gameRelation.getRelationship());
		assertEquals("Sequel", gameRelation.getRelationship().getName());
	}

}
