package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	List<Game> findDistnctByCompanies_game_id(int id);
	List<Company> findDistnctByCompanies_company_id(int id);
	List<Game> findByTitleLike(String keyword);
}
