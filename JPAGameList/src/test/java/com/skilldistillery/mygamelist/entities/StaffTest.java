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

class StaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
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
		em = emf.createEntityManager();
		staff = em.find(Staff.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		staff = null;
	}

	@Test
	void test_staff_name_mapping() {
		assertNotNull(staff);
		assertEquals("Casey Hudson", staff.getName());
	}
	
	@Test
	void test_staff_imageURL_mapping() {
		assertNotNull(staff);
		assertTrue(staff.getImageURL().contains("https"));
	}
	
	@Test
	void test_staff_description_mapping() {
		assertNotNull(staff);
		assertTrue(staff.getDescription().contains("Bioware"));
	}
	
	@Test
	void test_staff_createdDateTime_mapping() {
		assertNotNull(staff);
		assertEquals(1, staff.getCreatedDateTime().getMonthValue());
		assertEquals(7, staff.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_staff_updatedDateTime_mapping() {
		assertNotNull(staff);
		assertEquals(1, staff.getUpdatedDateTime().getMonthValue());
		assertEquals(8, staff.getUpdatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_Staff_games_mapping() {
		assertNotNull(staff);
		assertNotNull(staff.getGames());
		assertFalse(staff.getGames().isEmpty());
		assertEquals("Mass Effect", staff.getGames().get(0).getGame().getTitle());
	}
}
