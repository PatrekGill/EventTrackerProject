package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.compositeids.GameStaffId;
import com.skilldistillery.mygamelist.entities.GameStaff;

public interface GameStaffRepository extends JpaRepository<GameStaff, GameStaffId> {

}
