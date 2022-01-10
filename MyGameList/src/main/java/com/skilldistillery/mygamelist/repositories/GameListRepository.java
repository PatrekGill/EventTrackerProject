package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Integer> {
	
}
