package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;

public interface PlatformService extends CRUDObject<Platform,Integer> {
	List<Platform> findAll();
	List<Platform> getPlatformsForGame(int gameID);
	List<Game> getGamesForPlatform(int platformID);
}
