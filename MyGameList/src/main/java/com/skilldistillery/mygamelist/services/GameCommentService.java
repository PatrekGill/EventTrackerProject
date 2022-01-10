package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.GameComment;

public interface GameCommentService {
	GameComment findById(int id);
	boolean existsById(int id);
	List<GameComment> getNonReplyCommentsOnGame(int id);
	GameComment create(GameComment comment);
	GameComment update(int id, GameComment comment);
	boolean delete(int id);
}
