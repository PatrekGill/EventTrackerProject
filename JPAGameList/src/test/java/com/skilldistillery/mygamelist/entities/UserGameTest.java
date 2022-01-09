package com.skilldistillery.mygamelist.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.mygamelist.compositeids.UserGameId;

class UserGameTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private UserGameId userGameId;
	private UserGame userGame;
	private Game game;
	private User user;
	
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
		game = new Game(1);
		user = new User(1);
		userGameId = new UserGameId(user,game);
		
		em = emf.createEntityManager();
		userGame = em.find(UserGame.class, userGameId);
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
		user = null;
		userGameId = null;
		
		em.close();
		userGame = null;
	}

	@Test
	void test_UserGame_notes_mapping() {
		assertNotNull(userGame);
		assertEquals("some notes", userGame.getNotes());
	}
	
	@Test
	void test_UserGame_game_mapping() {
		assertNotNull(userGame);
		assertNotNull(userGame.getGame());
		assertEquals(1, userGame.getGame().getId());
	}
	
	@Test
	void test_UserGame_status_mapping() {
		assertNotNull(userGame);
		assertNotNull(userGame.getStatus());
		assertEquals(2, userGame.getStatus().getId());
	}
	
	@Test
	void test_UserGame_score_mapping() {
		assertNotNull(userGame);
		assertEquals(90, userGame.getScore());
	}
	
	@Test
	void test_UserGame_HoursPlayed_mapping() {
		assertNotNull(userGame);
		assertEquals(50.5, userGame.getHoursPlayed());
	}
	
	@Test
	void test_UserGame_StartDate_mapping() {
		assertNotNull(userGame);
		assertEquals(1, userGame.getStartDate().getMonthValue());
		assertEquals(6, userGame.getStartDate().getDayOfMonth());
	}
	
	@Test
	void test_UserGame_FinishDate_mapping() {
		assertNotNull(userGame);
		assertEquals(1, userGame.getFinishDate().getMonthValue());
		assertEquals(8, userGame.getFinishDate().getDayOfMonth());
	}
	

}
