package com.skilldistillery.mygamelist.services.staff;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;

public interface StaffService extends CRUDObject<Staff,Integer> {
	List<Staff> findAll();
	List<Staff> getStaffForGameById(int gameId);
	List<Game> getGamesForStaffById(int staffId);
}
