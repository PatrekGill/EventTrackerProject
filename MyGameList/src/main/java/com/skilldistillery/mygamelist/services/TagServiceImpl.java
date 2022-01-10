package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Tag;
import com.skilldistillery.mygamelist.repositories.TagRepository;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository tagRepo;
	@Autowired
	private OptionalRetriever<Tag> tagRetriever;
	
	@Override
	public List<Tag> findAll() {
		return tagRepo.findAll();
	}
	
	@Override
	public Tag findById(int id) {
		return tagRetriever.get(
			tagRepo.findById(id)
		);
	}

	@Override
	public List<Tag> findByNameLike(String name) {
		List<Tag> tags = null;
		if (name != null) {
			tags = tagRepo.findByNameLike("%" + name + "%");
		}
		
		return tags;
	}

	@Override
	public List<Game> getGamesByTagId(int id) {
		List<Game> games = null;
		Tag tag = findById(id);
		if (tag != null) {
			games = tag.getGames();
		}
		
		return games;
	}
}
