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

import com.skilldistillery.mygamelist.compositeids.GameStaffId;

class GameStaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private GameStaff gameStaff;
	
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
		gameStaff = em.find(GameStaff.class,new GameStaffId(1,1));
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		gameStaff = null;
	}

	@Test
	void test_GameStaff_role_mapping() {
		assertNotNull(gameStaff);
		assertEquals("Project Director", gameStaff.getRole());
	}

}
