package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.GameComment;

public interface GameCommentService {
	GameComment findById(int id);
	List<GameComment> getNonReplyCommentsOnGame(int id);
}
