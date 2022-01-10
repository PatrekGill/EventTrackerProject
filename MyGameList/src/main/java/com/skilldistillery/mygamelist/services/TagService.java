package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Tag;

public interface TagService {
	List<Tag> findAll();
	List<Tag> findByNameLike(String name);
	List<Game> getGamesByTagId(int id);
	Tag findById(int id);
	boolean existsById(int id);
}
