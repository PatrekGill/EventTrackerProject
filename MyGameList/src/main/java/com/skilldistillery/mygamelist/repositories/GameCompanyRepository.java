package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;

public interface GameCompanyRepository extends JpaRepository<GameCompany, GameCompanyId> {
	GameCompany findByGame_idAndCompany_id(int gameId,int companyId);
}
