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

public class RelationshipTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Relationship relationship;
	
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
		relationship = em.find(Relationship.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		relationship = null;
	}

	@Test
	void test_tag_name_mapping() {
		assertNotNull(relationship);
		assertEquals("Sequel", relationship.getName());
	}
}
