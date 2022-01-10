package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.GameList;

public interface GameListService {
	List<GameList> findAll();
	GameList findById(int id);
	boolean existsById(int id);
}
