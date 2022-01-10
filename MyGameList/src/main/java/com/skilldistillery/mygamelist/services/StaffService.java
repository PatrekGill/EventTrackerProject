package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;

public interface StaffService {
	List<Staff> findAll();
	Staff findById(int id);
	
	List<Staff> getStaffForGameById(int gameId);
	List<Game> getGamesForStaffById(int staffId);
}
