package com.skilldistillery.mygamelist.controllers.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.services.game.GameService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*","http://localhost:4202"})
public class GameSearchController {
	@Autowired
	private GameService gameService;
	
	/* ----------------------------------------------------------------------------
		GET games by title keyword 
	---------------------------------------------------------------------------- */
	@GetMapping("games/search/{keyword}")
	public List<Game> getGamesByTitleKeyword(
		@PathVariable String keyword
	) {
		return gameService.findByTitleLike(keyword);
	}
}
