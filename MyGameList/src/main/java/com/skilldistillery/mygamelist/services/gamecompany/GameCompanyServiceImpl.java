package com.skilldistillery.mygamelist.services.gamecompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;
import com.skilldistillery.mygamelist.repositories.GameCompanyRepository;

@Service
public class GameCompanyServiceImpl implements GameCompanyService {
	@Autowired
	private GameCompanyRepository gcRepo;
	@Autowired
	private OptionalRetriever<GameCompany> retriever;
	@Override
	public JpaRepository<GameCompany, GameCompanyId> getRepo() {
		return gcRepo;
	}
	@Override
	public OptionalRetriever<GameCompany> getRetriever() {
		return retriever;
	}
	
	@Override
	public GameCompany findByGame_idAndCompany_id(int gameId, int companyId) {
		return gcRepo.findByGame_idAndCompany_id(gameId, companyId); 
	}


}
