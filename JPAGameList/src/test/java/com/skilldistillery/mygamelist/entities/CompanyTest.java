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

class CompanyTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
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
		em = emf.createEntityManager();
		company = em.find(Company.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		company = null;
	}

	@Test
	void test_company_name_mapping() {
		assertNotNull(company);
		assertEquals("Bioware", company.getName());
	}
	
	@Test
	void test_company_imageURL_mapping() {
		assertNotNull(company);
		assertTrue(company.getImageURL().contains("https"));
	}
	
	@Test
	void test_staff_description_mapping() {
		assertNotNull(company);
		assertTrue(company.getDescription().contains("rpg studio"));
	}
	
	@Test
	void test_company_createdDateTime_mapping() {
		assertNotNull(company);
		assertEquals(1, company.getCreatedDateTime().getMonthValue());
		assertEquals(7, company.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_company_updatedDateTime_mapping() {
		assertNotNull(company);
		assertEquals(1, company.getUpdateDateTime().getMonthValue());
		assertEquals(8, company.getUpdateDateTime().getDayOfMonth());
	}

	@Test
	void test_game_companies_mapping() {
		assertNotNull(company);
		assertNotNull(company.getGames());
		assertFalse(company.getGames().isEmpty());
		assertEquals("Mass Effect", company.getGames().get(0).getTitle());
	}
}
