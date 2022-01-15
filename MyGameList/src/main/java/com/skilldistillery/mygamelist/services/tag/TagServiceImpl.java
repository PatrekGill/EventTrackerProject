package com.skilldistillery.mygamelist.services.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
	private OptionalRetriever<Tag> retriever;
	@Override
	public JpaRepository<Tag, Integer> getRepo() {
		return tagRepo;
	}
	@Override
	public OptionalRetriever<Tag> getRetriever() {
		return retriever;
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
