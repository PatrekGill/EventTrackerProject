package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Tag;
import com.skilldistillery.mygamelist.services.TagService;

@RestController
@RequestMapping("api")
public class TagController {
	@Autowired
	private TagService tagService;

	/* ----------------------------------------------------------------------------
		GET all tags
	---------------------------------------------------------------------------- */
	@GetMapping("tags")
	public List<Tag> getAllTags() {
		return tagService.findAll();
	}
	
	/* ----------------------------------------------------------------------------
		GET Tag By ID
	---------------------------------------------------------------------------- */
	@GetMapping("tags/{id}")
	public Tag getTagById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Tag tag = null;
		try {
			tag = tagService.findById(id);
			if (tag == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return tag;
	}
	
	/* ----------------------------------------------------------------------------
		GET search Tag by name
	---------------------------------------------------------------------------- */
	@GetMapping("tags/search/{name}")
	public List<Tag> getTagsByName(
		@PathVariable String name,
		HttpServletResponse res
	) {
		List<Tag> tags = null;
		try {
			tags = tagService.findByNameLike(name);
			if (tags == null) {
				res.setStatus(400);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return tags;
	}
	
	/* ----------------------------------------------------------------------------
		GET games by Tag ID
	---------------------------------------------------------------------------- */
	@GetMapping("tags/{id}/games")
	public List<Game> getGamesByTagId(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<Game> games = null;
		try {
			games = tagService.getGamesByTagId(id);
			if (games == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return games;
	}
}
