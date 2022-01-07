package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
