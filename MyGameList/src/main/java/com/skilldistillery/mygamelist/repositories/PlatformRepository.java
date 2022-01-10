package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
	@Query("SELECT DISTINCT gr.game FROM GameRelease gr WHERE gr.game.id = :id")
	List<Game> getGamesForPlatformById(@Param("id") int id);
	
	@Query("SELECT DISTINCT gr.platform FROM GameRelease gr WHERE gr.platform.id = :id")
	List<Platform> getPlatformsForGameById(@Param("id") int id);
}
