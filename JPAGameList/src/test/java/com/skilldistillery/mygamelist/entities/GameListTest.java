package com.skilldistillery.mygamelist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

class GameListTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private GameList gameList;
	
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
		gameList = em.find(GameList.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		gameList = null;
	}
	
	
	@Test
	void test_GameList_name_mapping() {
		assertNotNull(gameList);
		assertEquals("Playing", gameList.getName());
	}
	
	@Test
	void test_GameList_permanent_mapping() {
		assertNotNull(gameList);
		assertTrue(gameList.isPermanent());
	}
	
	@Test
	void test_GameList_user_mapping() {
		assertNotNull(gameList);
		assertNotNull(gameList.getUser());
		assertEquals(1,gameList.getUser().getId());
	}
	
	@Test
	void test_GameList_games_mapping() {
		assertNotNull(gameList);
		assertNotNull(gameList.getGames());
		assertFalse(gameList.getGames().isEmpty());
		assertEquals("Mass Effect",gameList.getGames().get(0).getTitle());
	}

	@Test
	void test_GameList_createdDateTime_mapping() {
		assertNotNull(gameList);
		assertEquals(1, gameList.getCreatedDateTime().getMonthValue());
		assertEquals(7, gameList.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_GameList_updatedDateTime_mapping() {
		assertNotNull(gameList);
		assertEquals(1, gameList.getUpdateDateTime().getMonthValue());
		assertEquals(8, gameList.getUpdateDateTime().getDayOfMonth());
	}
}
