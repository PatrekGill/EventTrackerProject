package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Game;

public interface GameService {
	List<Game> getAllGames();
	Game getGameById(int id);
}
