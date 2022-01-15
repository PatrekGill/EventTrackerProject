package com.skilldistillery.mygamelist.services.tag;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Tag;

public interface TagService extends CRUDObject<Tag,Integer> {
	List<Tag> findByNameLike(String name);
	List<Game> getGamesByTagId(int id);
}
