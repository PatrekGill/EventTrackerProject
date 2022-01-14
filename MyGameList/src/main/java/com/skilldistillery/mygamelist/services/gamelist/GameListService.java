package com.skilldistillery.mygamelist.services.gamelist;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.GameList;

public interface GameListService extends CRUDObject<GameList,Integer> {
	List<GameList> findAll();
}
