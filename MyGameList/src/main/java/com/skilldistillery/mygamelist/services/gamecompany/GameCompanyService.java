package com.skilldistillery.mygamelist.services.gamecompany;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;

public interface GameCompanyService extends CRUDObject<GameCompany,GameCompanyId> {
	GameCompany findByGame_idAndCompany_id(int gameId,int companyId);
}
