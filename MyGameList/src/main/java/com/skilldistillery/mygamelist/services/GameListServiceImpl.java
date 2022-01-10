package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.GameList;
import com.skilldistillery.mygamelist.repositories.GameListRepository;

@Service
public class GameListServiceImpl implements GameListService {
	@Autowired
	private GameListRepository glRepo;
	@Autowired
	private OptionalRetriever<GameList> gameListRetriever;
	
	@Override
	public List<GameList> findAll() {
		return glRepo.findAll();
	}

	@Override
	public GameList findById(int id) {
		return gameListRetriever.get(
			glRepo.findById(id)
		);
	}
	
}
