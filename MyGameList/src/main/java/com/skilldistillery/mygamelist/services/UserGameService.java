package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.compositeids.UserGameId;
import com.skilldistillery.mygamelist.entities.UserGame;

public interface UserGameService {
	UserGame findById(UserGameId id);
	List<UserGame> findByUserId(int id);
	List<UserGame> findByGameId(int id);
	UserGame findByGameAndUserId(int gameId, int userId);
}
