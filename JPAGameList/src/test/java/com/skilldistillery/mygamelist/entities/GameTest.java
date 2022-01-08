package com.skilldistillery.mygamelist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Game game;
	
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
		em = emf.createEntityManager();
		game = em.find(Game.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		game = null;
	}

	@Test
	void test_game_title_mapping() {
		assertNotNull(game);
		assertEquals("Mass Effect", game.getTitle());
	}
	
	@Test
	void test_game_createdDateTime_mapping() {
		assertNotNull(game);
		assertEquals(1, game.getCreatedDateTime().getMonthValue());
		assertEquals(7, game.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_game_updatedDateTime_mapping() {
		assertNotNull(game);
		assertEquals(1, game.getUpdateDateTime().getMonthValue());
		assertEquals(8, game.getUpdateDateTime().getDayOfMonth());
	}
	
	@Test
	void test_game_description_mapping() {
		assertNotNull(game);
		assertEquals("First Mass Effect", game.getDescription());
	}
	
	@Test
	void test_game_imageURL_mapping() {
		assertNotNull(game);
		assertNotNull(game.getImageURL());
		assertTrue(game.getImageURL().contains("https"));
	}

}
