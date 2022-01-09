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

import com.skilldistillery.mygamelist.compositeids.GameReleaseId;

class GameReleaseTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private GameReleaseId releaseId;
	private GameRelease release;
	private Game game;
	private Platform platform;
	
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
		platform = new Platform(1);
		releaseId = new GameReleaseId(game,platform);
		
		em = emf.createEntityManager();
		release = em.find(GameRelease.class, releaseId);
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
		platform = null;
		releaseId = null;
		
		em.close();
		release = null;
	}
	
	
	@Test
	void test_Release_platform_mapping() {
		assertNotNull(release);
		assertNotNull(release.getPlatform());
		assertEquals("PC", release.getPlatform().getAbbreviation());
	}
	
	@Test
	void test_Release_game_mapping() {
		assertNotNull(release);
		assertNotNull(release.getGame());
		assertEquals(1, release.getGame().getId());
	}
	
	@Test
	void test_Release_date_mapping() {
		assertNotNull(release);
		assertNotNull(release.getDate());
		assertEquals(2008, release.getDate().getYear());
		assertEquals(5, release.getDate().getMonthValue());
		assertEquals(28, release.getDate().getDayOfMonth());
	}

}
