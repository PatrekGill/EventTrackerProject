package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.GameCompany;
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
		return gameService.findAll();
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
			game = gameService.findById(id);
			if (game == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return game;
	}
	

	/* ----------------------------------------------------------------------------
		GET game's company roles by id
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/companyroles")
	public List<GameCompany> getCompanyGameRoles(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameCompany> games = null;
		try {
			Game company = gameService.findById(id);
			if (company == null) {
				res.setStatus(404);
				
			} else {
				games = company.getCompanies();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return games;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET game's companies by id
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/companies")
	public List<Company> getGameCompaniesById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<Company> companies = null;
		try {
			companies = gameService.getCompaniesByGame(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return companies;
	}
}
