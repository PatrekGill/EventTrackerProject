package com.skilldistillery.mygamelist.services.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
	private OptionalRetriever<Game> retriever;

	@Override
	public JpaRepository<Game, Integer> getRepo() {
		return gameRepo;
	}
	@Override
	public OptionalRetriever<Game> getRetriever() {
		return retriever;
	}
	

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
