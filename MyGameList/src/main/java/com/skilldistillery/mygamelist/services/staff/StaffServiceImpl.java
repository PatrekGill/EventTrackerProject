package com.skilldistillery.mygamelist.services.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;
import com.skilldistillery.mygamelist.repositories.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository staffRepo;
	@Autowired
	private OptionalRetriever<Staff> retriever;
	@Override
	public JpaRepository<Staff, Integer> getRepo() {
		return staffRepo;
	}
	@Override
	public OptionalRetriever<Staff> getRetriever() {
		return retriever;
	}

	@Override
	public List<Staff> getStaffForGameById(int gameId) {
		return staffRepo.getStaffForGameById(gameId);
	}

	@Override
	public List<Game> getGamesForStaffById(int staffId) {
		return staffRepo.getGamesForStaffById(staffId);
	}
}
