package com.skilldistillery.mygamelist.controllers.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.services.game.GameService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*","http://localhost:4202"})
public class GameModifyController {
	@Autowired
	private GameService gameService;
	
	/* ----------------------------------------------------------------------------
		POST create new game
	---------------------------------------------------------------------------- */
	@PostMapping("games")
	public Game createGame(
		@RequestBody Game game,
		HttpServletResponse res,
		HttpServletRequest req
	) {
		
		try {
			if (game.getTitle().equals("")) {
				System.err.println("Tried to create game without title");
				throw new Exception();
			}
			
			game = gameService.create(game);
			res.setStatus(201);
			
			StringBuffer url = req.getRequestURL();
			url.append("/").append(game.getId());
			res.setHeader("Location",url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid game sent to create");
			res.setStatus(400);

			game = null;
			
		}
		
		return game;
	}
	
	/* ----------------------------------------------------------------------------
		PUT update game
	---------------------------------------------------------------------------- */
	@PutMapping("games/{id}")
	public Game updateGame(
		@PathVariable int id,
		@RequestBody Game game,
		HttpServletResponse res
	) {
		try {
			game = gameService.update(id, game, g -> true);
			if (game == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid game sent to update");
			res.setStatus(400);
			game = null;
			
		}
		
		return game;
	}
	
	/* ----------------------------------------------------------------------------
		DELETE game
	---------------------------------------------------------------------------- */
	@DeleteMapping("games/{id}")
	public void deleteGame(
		@PathVariable int id,
		HttpServletResponse res
	) {
		if (gameService.existsById(id)) {
			if (gameService.deleteById(id, g -> true)) {
				res.setStatus(204);
				
			} else {
				res.setStatus(409);
				
			}
			
		} else {
			res.setStatus(404);
			
		}
		
	}
	
}
