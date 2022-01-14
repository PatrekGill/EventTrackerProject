package com.skilldistillery.mygamelist.services.gamelist;

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
	public GameList findById(Integer id) {
		return gameListRetriever.get(
			glRepo.findById(id)
		);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return glRepo.existsById(id);
	}

	@Override
	public GameList create(GameList object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameList update(Integer id, GameList object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
