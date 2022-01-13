package com.skilldistillery.mygamelist.services;

import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;

public interface GameCompanyService {
	GameCompany findByGame_idAndCompany_id(int gameId,int companyId);
	GameCompany findById(GameCompanyId id);
	boolean existsById(GameCompanyId id);
	GameCompany create(GameCompany gc);
	GameCompany update(GameCompany gc);
	boolean delete(GameCompany gc);
}
