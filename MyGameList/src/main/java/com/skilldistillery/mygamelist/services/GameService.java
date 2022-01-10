package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;

public interface GameService {
	List<Game> findAll();
	Game findById(int id);
	List<Game> getGamesByCompany(int id);
	List<Game> findByTitleLike(String keyword);
	List<Company> getCompaniesByGame(int id);
	Game create(Game game);
	Game update(int id,Game game);
}
