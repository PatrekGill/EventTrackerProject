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

class GameReleaseTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private GameRelease release;
	
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
		release = em.find(GameRelease.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
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
