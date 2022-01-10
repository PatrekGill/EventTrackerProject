package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.GameComment;

public interface GameService {
	List<Game> findAll();
	Game findById(int id);
	List<Game> getGamesByCompany(int id);
	List<Company> getCompaniesByGame(int id);
	List<GameComment> getNonReplyCommentsOnGame(int id);
}
