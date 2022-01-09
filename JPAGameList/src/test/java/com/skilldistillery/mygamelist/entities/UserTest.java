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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
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
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	
	
	@Test
	void test_User_username_mapping() {
		assertNotNull(user);
		assertEquals("admin",user.getUsername());
	}
	
	@Test
	void test_User_password_mapping() {
		assertNotNull(user);
		assertEquals("admin",user.getPassword());
	}
	
	@Test
	void test_User_createdDateTime_mapping() {
		assertNotNull(user);
		assertEquals(1, user.getCreatedDateTime().getMonthValue());
		assertEquals(7, user.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_User_updatedDateTime_mapping() {
		assertNotNull(user);
		assertEquals(1, user.getUpdateDateTime().getMonthValue());
		assertEquals(8, user.getUpdateDateTime().getDayOfMonth());
	}
	
	@Test
	void test_User_gameLists_mapping() {
		assertNotNull(user);
		assertNotNull(user.getGameLists());
		assertFalse(user.getGameLists().isEmpty());
		assertEquals("Playing",user.getGameLists().get(0).getName());
	}
}
