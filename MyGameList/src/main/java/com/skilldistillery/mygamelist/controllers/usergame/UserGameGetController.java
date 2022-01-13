package com.skilldistillery.mygamelist.controllers.usergame;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.UserGame;
import com.skilldistillery.mygamelist.services.UserGameService;

@RestController
@RequestMapping("api")
public class UserGameGetController {
	@Autowired
	private UserGameService userGameService;
	
	/* ----------------------------------------------------------------------------
		GET User's games
	---------------------------------------------------------------------------- */
	@GetMapping("users/{id}/userGames")
	public List<UserGame> getUsersGames(
		@PathVariable int id
	) {
		return userGameService.findByUserId(id);
	}
	
	/* ----------------------------------------------------------------------------
		GET User's games
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/userGames")
	public List<UserGame> getGamesUserGames(
		@PathVariable int id
	) {
		return userGameService.findByGameId(id);
	}
	
	/* ----------------------------------------------------------------------------
		GET UserGame by id
	---------------------------------------------------------------------------- */
	@GetMapping("users/{userId}/games/{gameId}")
	public UserGame getUserGameById(
		@PathVariable int userId,
		@PathVariable int gameId,
		HttpServletResponse res
	) {
		UserGame game = null;
		try {
			game = userGameService.findByGameAndUserId(gameId,userId);
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
