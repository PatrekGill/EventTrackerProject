package com.skilldistillery.mygamelist.services.gamerelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.GameRelationId;
import com.skilldistillery.mygamelist.entities.GameRelation;
import com.skilldistillery.mygamelist.repositories.GameRelationRepository;

@Service
public class GameRelationServiceImpl implements GameRelationService {
	@Autowired
	GameRelationRepository repo;
	@Autowired
	OptionalRetriever<GameRelation> retriever;
	@Override
	public JpaRepository<GameRelation, GameRelationId> getRepo() {
		return repo;
	}
	@Override
	public OptionalRetriever<GameRelation> getRetriever() {
		return retriever;
	}

}
