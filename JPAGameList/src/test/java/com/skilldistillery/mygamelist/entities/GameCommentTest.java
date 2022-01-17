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

class GameCommentTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private GameComment comment;
	
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
		comment = em.find(GameComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comment = null;
	}

	@Test
	void test_GameComment_text_mapping() {
		assertNotNull(comment);
		assertTrue(comment.getText().contains("Good"));
	}
	
	@Test
	void test_GameComment_visibile_mapping() {
		assertNotNull(comment);
		assertTrue(comment.isVisible());
	}

	@Test
	void test_GameComment_user_mapping() {
		assertNotNull(comment);
		assertNotNull(comment.getUser());
		assertEquals(1,comment.getUser().getId());
	}
	
	@Test
	void test_GameComment_replyToComment_mapping() {
		comment = em.find(GameComment.class, 2);
		assertNotNull(comment);
		assertNotNull(comment.getReplyToComment());
		assertEquals(1,comment.getReplyToComment().getId());
	}
	
	@Test
	void test_GameComment_game_mapping() {
		assertNotNull(comment);
		assertNotNull(comment.getGame());
		assertEquals(1,comment.getGame().getId());
	}
	
	@Test
	void test_GameComment_replies_mapping() {
		assertNotNull(comment);
		assertNotNull(comment.getReplies());
		assertFalse(comment.getReplies().isEmpty());
		assertEquals(2,comment.getReplies().get(0).getId());
	}

	
	@Test
	void test_GameComment_createdDateTime_mapping() {
		assertNotNull(comment);
		assertEquals(1, comment.getCreatedDateTime().getMonthValue());
		assertEquals(7, comment.getCreatedDateTime().getDayOfMonth());
	}
	
	@Test
	void test_GameComment_updatedDateTime_mapping() {
		assertNotNull(comment);
		assertNotNull(comment.getUpdateDateTime());
//		assertEquals(1, comment.getUpdateDateTime().getMonthValue());
//		assertEquals(8, comment.getUpdateDateTime().getDayOfMonth());
	}
}
