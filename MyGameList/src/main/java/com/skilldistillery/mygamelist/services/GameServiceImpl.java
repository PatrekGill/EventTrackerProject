package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameRepository gameRepo;
	@Autowired
	private OptionalRetriever<Game> gameRetriever;
	
	@Override
	public List<Game> findAll() {
		return gameRepo.findAll();
	}
	
	@Override
	public Game findById(int id) {
		return gameRetriever.get(
			gameRepo.findById(id)
		);
	}
	
	@Override
	public List<Game> getGamesByCompany(int companyID) {
		return gameRepo.getGamesForCompanyId(companyID);
	}

	@Override
	public List<Company> getCompaniesByGame(int gameID) {
		return gameRepo.getCompaniesForGameId(gameID);
	}

}
