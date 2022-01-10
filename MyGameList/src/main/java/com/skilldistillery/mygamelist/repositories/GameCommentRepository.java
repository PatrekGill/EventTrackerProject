package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.mygamelist.entities.GameComment;

public interface GameCommentRepository extends JpaRepository<GameComment, Integer> {
	@Query("SELECT gc "
			+ "FROM GameComment gc "
			+ "WHERE gc.game.id = :id "
				+ "AND gc.visible = true "
				+ "AND gc.replyToComment IS NULL")
	List<GameComment> getVisibleAndNonReplyingCommentsOnGameById(@Param("id") int id);

}
