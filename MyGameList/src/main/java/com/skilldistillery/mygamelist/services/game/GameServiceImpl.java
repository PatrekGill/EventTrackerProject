package com.skilldistillery.mygamelist.services.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.repositories.GameRepository;

@Service
public class GameServiceImpl extends CRUDObject<Game, Integer> implements GameService {
	@Autowired
	private GameRepository gameRepo;

	@Override
	public List<Game> getGamesByCompany(int companyID) {
		return gameRepo.findDistnctByCompanies_game_id(companyID);
	}

	@Override
	public List<Company> getCompaniesByGame(int gameID) {
		return gameRepo.findDistnctByCompanies_company_id(gameID);
	}

	@Override
	public List<Game> findByTitleLike(String keyword) {
		return gameRepo.findByTitleLike("%" + keyword + "%");
	}

	
	
}
