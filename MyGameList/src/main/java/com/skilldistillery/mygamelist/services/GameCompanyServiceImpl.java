package com.skilldistillery.mygamelist.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	public boolean existsById(GameCompanyId id) {
		return gcRepo.existsById(id);
	}

	@Override
	public GameCompany create(GameCompany gc) {
		return gcRepo.saveAndFlush(gc);
	}

	@Override
	public GameCompany update(GameCompanyId id,GameCompany gc) {
		GameCompany managed = findById(id);
		if (managed != null) {
			managed.setRole(gc.getRole());
		}
		
		return managed;
	}

	@Override
	public boolean delete(GameCompanyId id) {
		gcRepo.deleteById(id);
		boolean deleted = false;
		if (!gcRepo.existsById(id)) {
			deleted = true;
			
		} else {
			deleted = false;
			
		}
		
		return deleted;
	}



}
