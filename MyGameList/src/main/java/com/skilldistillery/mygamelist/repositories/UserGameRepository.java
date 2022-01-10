package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.compositeids.UserGameId;
import com.skilldistillery.mygamelist.entities.UserGame;

public interface UserGameRepository extends JpaRepository<UserGame, UserGameId> {
	List<UserGame> findByUser_id(int id);
	List<UserGame> findByGame_id(int id);
	UserGame findByGame_idAndUser_id(int gameId, int userId);
}
