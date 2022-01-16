package com.skilldistillery.mygamelist.services.gamerelease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.GameReleaseId;
import com.skilldistillery.mygamelist.entities.GameRelease;
import com.skilldistillery.mygamelist.repositories.GameReleaseRepository;

@Service
public class GameReleaseServiceImpl implements GameReleaseService {
	@Autowired
	GameReleaseRepository repo;
	@Autowired
	OptionalRetriever<GameRelease> retriever;
	@Override
	public JpaRepository<GameRelease, GameReleaseId> getRepo() {
		return repo;
	}
	@Override
	public OptionalRetriever<GameRelease> getRetriever() {
		return retriever;
	}

}
