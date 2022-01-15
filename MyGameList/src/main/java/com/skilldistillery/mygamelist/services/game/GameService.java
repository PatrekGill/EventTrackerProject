package com.skilldistillery.mygamelist.services.game;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;

public interface GameService {
	List<Game> getGamesByCompany(int id);
	List<Game> findByTitleLike(String keyword);
	List<Company> getCompaniesByGame(int id);
}
