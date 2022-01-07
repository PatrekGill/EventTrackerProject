package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameRepository gameRepo;
	
	@Override
	public List<Game> getAllGames() {
		return gameRepo.findAll();
	}

	@Override
	public Game getGameById(int id) {
		return gameRepo.getById(id);
	}

}
