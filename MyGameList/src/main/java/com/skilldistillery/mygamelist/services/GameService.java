package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;

public interface GameService extends CRUDObject<Game,Integer> {
	List<Game> findAll();
	List<Game> getGamesByCompany(int id);
	List<Game> findByTitleLike(String keyword);
	List<Company> getCompaniesByGame(int id);
}
