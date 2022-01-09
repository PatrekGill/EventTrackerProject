package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.services.GameService;

@RestController
@RequestMapping("api")
public class GameController {
	@Autowired
	private GameService gameService;
	
	/* ----------------------------------------------------------------------------
		GET all games
	---------------------------------------------------------------------------- */
	@GetMapping("games")
	public List<Game> index() {
		return gameService.getAllGames();
	}
	
	/* ----------------------------------------------------------------------------
		GET game by id
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}")
	public Game getGameById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Game game = null;
		try {
			game = gameService.getGameById(id);
			if (game == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return game;
	}
}
