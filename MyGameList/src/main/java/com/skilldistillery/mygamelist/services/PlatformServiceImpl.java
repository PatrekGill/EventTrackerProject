package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;
import com.skilldistillery.mygamelist.repositories.PlatformRepository;

@Service
public class PlatformServiceImpl implements PlatformService {
	@Autowired
	PlatformRepository platformRepo;
	@Autowired
	private OptionalRetriever<Platform> platformRetriever;
	
	@Override
	public List<Platform> findAll() {
		return platformRepo.findAll();
	}

	@Override
	public Platform findById(Integer id) {
		return platformRetriever.get(
			platformRepo.findById(id)
		);
	}

	@Override
	public List<Platform> getPlatformsForGame(int platformID) {
		return platformRepo.getPlatformsForGameById(platformID);
	}

	@Override
	public List<Game> getGamesForPlatform(int gameID) {
		return platformRepo.getGamesForPlatformById(gameID);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return platformRepo.existsById(id);
	}

	@Override
	public Platform create(Platform object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Platform update(Integer id, Platform object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
