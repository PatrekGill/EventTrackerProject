package com.skilldistillery.mygamelist.services.gamestaff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.GameStaffId;
import com.skilldistillery.mygamelist.entities.GameStaff;
import com.skilldistillery.mygamelist.repositories.GameStaffRepository;

@Service
public class GameStaffServiceImpl implements GameStaffService {
	@Autowired
	GameStaffRepository repo;
	@Autowired
	OptionalRetriever<GameStaff> retriever;
	@Override
	public JpaRepository<GameStaff, GameStaffId> getRepo() {
		return repo;
	}
	@Override
	public OptionalRetriever<GameStaff> getRetriever() {
		return retriever;
	}

}
