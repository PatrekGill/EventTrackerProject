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

import com.skilldistillery.mygamelist.compositeids.GameCompanyId;

public class GameCompanyTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private GameCompanyId gameCompanyId;
	private GameCompany gameCompany;
	private Game game;
	private Company company;
	
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
		company = new Company(1);
		gameCompanyId = new GameCompanyId(game,company);
		
		em = emf.createEntityManager();
		gameCompany = em.find(GameCompany.class,gameCompanyId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		
		gameCompanyId = null;
		company = null;
		game = null;
		gameCompany = null;
	}

	
	@Test
	void test_GameCompany_game_mapping() {
		assertNotNull(gameCompany);
		assertNotNull(gameCompany.getGame());
		assertEquals("Mass Effect", gameCompany.getGame().getTitle());
	}
	
	@Test
	void test_GameCompany_company_mapping() {
		assertNotNull(gameCompany);
		assertNotNull(gameCompany.getCompany());
		assertEquals("Bioware", gameCompany.getCompany().getName());
	}
	
	@Test
	void test_GameCompany_role_mapping() {
		assertNotNull(gameCompany);
		assertEquals("Developer", gameCompany.getRole());
	}
}
