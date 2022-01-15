package com.skilldistillery.mygamelist.services.gamelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.GameList;
import com.skilldistillery.mygamelist.repositories.GameListRepository;

@Service
public class GameListServiceImpl implements GameListService {
	@Autowired
	private GameListRepository glRepo;
	@Autowired
	private OptionalRetriever<GameList> retriever;
	
	@Override
	public JpaRepository<GameList, Integer> getRepo() {
		return glRepo;
	}
	@Override
	public OptionalRetriever<GameList> getRetriever() {
		return retriever;
	}	
}
