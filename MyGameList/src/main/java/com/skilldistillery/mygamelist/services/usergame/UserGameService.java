package com.skilldistillery.mygamelist.services.usergame;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.compositeids.UserGameId;
import com.skilldistillery.mygamelist.entities.UserGame;

public interface UserGameService extends CRUDObject<UserGame, UserGameId> {
	List<UserGame> findByUserId(int id);
	List<UserGame> findByGameId(int id);
	UserGame findByGameAndUserId(int gameId, int userId);
}
