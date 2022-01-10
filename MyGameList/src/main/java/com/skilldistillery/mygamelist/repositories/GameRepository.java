package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Tag;

public interface GameRepository extends JpaRepository<Game, Integer> {
	@Query("SELECT DISTINCT gc.game FROM GameCompany gc WHERE gc.game.id = :id")
	List<Game> queryByGameId(@Param("id") int id);
	
	@Query("SELECT DISTINCT gc.company FROM GameCompany gc WHERE gc.company.id = :id")
	List<Company> queryByCompanyId(@Param("id") int id);
	
}
