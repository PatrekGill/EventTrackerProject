package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.GameComment;

public interface GameCommentService extends CRUDObject<GameComment,Integer> {
	List<GameComment> getNonReplyCommentsOnGame(int id);
	List<GameComment> getCommentReplies(int id);
}
