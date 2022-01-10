package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	@Query("SELECT DISTINCT gs.staff FROM GameStaff gs WHERE gs.game.id = :id")
	List<Staff> getStaffForGameById(@Param("id") int gameId);
	
	@Query("SELECT DISTINCT gs.game FROM GameStaff gs WHERE gs.staff.id = :id")
	List<Game> getGamesForStaffById(@Param("id") int staffId);
}
