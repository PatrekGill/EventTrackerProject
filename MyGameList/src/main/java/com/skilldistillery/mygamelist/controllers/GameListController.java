package com.skilldistillery.mygamelist.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.GameList;
import com.skilldistillery.mygamelist.services.GameListService;

@RestController
@RequestMapping("api")
public class GameListController {
	@Autowired
	private GameListService gameListService;
	
	/* ----------------------------------------------------------------------------
		GET all gameLists
	---------------------------------------------------------------------------- */
	@GetMapping("gameLists")
	public List<GameList> index() {
		return gameListService.findAll();
	}
	
	
	/* ----------------------------------------------------------------------------
		GET gameList by Id
	---------------------------------------------------------------------------- */
	@GetMapping("gameLists/{id}")
	public GameList getGameListById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		GameList gameList = null;
		try {
			gameList = gameListService.findById(id);
			if (gameList == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return gameList;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET gameList's games by Id
	---------------------------------------------------------------------------- */
	@GetMapping("gameLists/{id}/games")
	public List<Game> getGamesOnGameList(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<Game> games = new ArrayList<>();
		try {
			GameList gameList = gameListService.findById(id);
			if (gameList == null) {
				res.setStatus(404);
				
			} else {
				games = gameList.getGames();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return games;
	}
}
