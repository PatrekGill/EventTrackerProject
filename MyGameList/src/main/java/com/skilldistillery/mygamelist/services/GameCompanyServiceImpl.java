package com.skilldistillery.mygamelist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;
import com.skilldistillery.mygamelist.entities.GameList;
import com.skilldistillery.mygamelist.repositories.GameCompanyRepository;

@Service
public class GameCompanyServiceImpl implements GameCompanyService {
	@Autowired
	private GameCompanyRepository gcRepo;
	@Autowired
	private OptionalRetriever<GameCompany> gameCompanyRetriever;
	
	@Override
	public GameCompany findByGame_idAndCompany_id(int gameId, int companyId) {
		return gcRepo.findByGame_idAndCompany_id(gameId, companyId); 
	}

	@Override
	public GameCompany findById(GameCompanyId id) {
		return gameCompanyRetriever.get(
			gcRepo.findById(id)
		);
				
	}

	@Override
	public GameCompany create(GameCompany gc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameCompany update(GameCompany gc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(GameCompany gc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(GameCompanyId id) {
		return gcRepo.existsById(id);
	}


}
