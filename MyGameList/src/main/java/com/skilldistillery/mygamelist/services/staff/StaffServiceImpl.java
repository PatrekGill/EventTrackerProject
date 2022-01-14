package com.skilldistillery.mygamelist.services.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private OptionalRetriever<Staff> staffRetriever;

	@Override
	public List<Staff> findAll() {
		return staffRepo.findAll();
	}

	@Override
	public Staff findById(Integer id) {
		return staffRetriever.get(
			staffRepo.findById(id)
		);
	}

	@Override
	public List<Staff> getStaffForGameById(int gameId) {
		return staffRepo.getStaffForGameById(gameId);
	}

	@Override
	public List<Game> getGamesForStaffById(int staffId) {
		return staffRepo.getGamesForStaffById(staffId);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return staffRepo.existsById(id);
	}

	@Override
	public Staff create(Staff object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff update(Integer id, Staff object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
}
