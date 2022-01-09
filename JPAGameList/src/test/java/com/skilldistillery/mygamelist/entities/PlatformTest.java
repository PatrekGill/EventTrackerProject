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

class PlatformTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
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
		em = emf.createEntityManager();
		platform = em.find(Platform.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		platform = null;
	}

	@Test
	void test_platform_name_mapping() {
		assertNotNull(platform);
		assertEquals("Windows", platform.getName());
	}
	
	@Test
	void test_platform_abbreviation_mapping() {
		assertNotNull(platform);
		assertEquals("PC", platform.getAbbreviation());
	}
	
	@Test
	void test_platform_releases_mapping() {
		assertNotNull(platform);
		assertNotNull(platform.getReleases());
		assertFalse(platform.getReleases().isEmpty());
		assertEquals("Mass Effect", platform.getReleases().get(0).getGame().getTitle());
	}

}
