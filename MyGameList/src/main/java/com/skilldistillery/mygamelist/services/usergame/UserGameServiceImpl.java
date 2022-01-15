package com.skilldistillery.mygamelist.services.usergame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.UserGameId;
import com.skilldistillery.mygamelist.entities.UserGame;
import com.skilldistillery.mygamelist.repositories.UserGameRepository;

@Service
public class UserGameServiceImpl implements UserGameService {
	@Autowired
	private UserGameRepository gameRepo;
	@Autowired
	private OptionalRetriever<UserGame> retriever;
	@Override
	public JpaRepository<UserGame, UserGameId> getRepo() {
		return gameRepo;
	}
	@Override
	public OptionalRetriever<UserGame> getRetriever() {
		return retriever;
	}
	
	@Override
	public List<UserGame> findByUserId(int id) {
		return gameRepo.findByUser_id(id);
	}
	
	@Override
	public List<UserGame> findByGameId(int id) {
		return gameRepo.findByGame_id(id);
	}

	@Override
	public UserGame findByGameAndUserId(int gameId, int userId) {
		return gameRepo.findByGame_idAndUser_id(gameId, userId);
	}	
	
}
