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

class GameStaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private GameStaffId gameStaffId;
	private GameStaff gameStaff;
	private Game game;
	private Staff staff;
	
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
		staff = new Staff(1);
		gameStaffId = new GameStaffId(game,staff);
		
		em = emf.createEntityManager();
		gameStaff = em.find(GameStaff.class,gameStaffId);
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
		staff = null;
		gameStaffId = null;
		
		em.close();
		gameStaff = null;
	}

	@Test
	void test_GameStaff_role_mapping() {
		assertNotNull(gameStaff);
		assertEquals("Project Director", gameStaff.getRole());
	}
	

	@Test
	void test_GameStaff_Game_mapping() {
		assertNotNull(gameStaff);
		assertNotNull(gameStaff.getGame());
		assertEquals("Mass Effect", gameStaff.getGame().getTitle());
	}

	@Test
	void test_GameStaff_Staff_mapping() {
		assertNotNull(gameStaff);
		assertNotNull(gameStaff.getStaff());
		assertEquals("Casey Hudson", gameStaff.getStaff().getName());
	}
}
