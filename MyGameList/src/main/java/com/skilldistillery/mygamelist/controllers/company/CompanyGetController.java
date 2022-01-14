package com.skilldistillery.mygamelist.controllers.company;

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
import com.skilldistillery.mygamelist.services.company.CompanyService;
import com.skilldistillery.mygamelist.services.game.GameService;

@RestController
@RequestMapping("api")
public class CompanyGetController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private GameService gameService;
	
	/* ----------------------------------------------------------------------------
		GET all companies
	---------------------------------------------------------------------------- */
	@GetMapping("companies")
	public List<Company> index() {
		return companyService.findAll();
	}
	
	
	/* ----------------------------------------------------------------------------
		GET Company by id
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}")
	public Company getCompanyById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Company company = null;
		if (companyService.existsById(id)) {
			company = companyService.findById(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return company;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET company games and roles by ID
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}/games/roles")
	public List<GameCompany> getCompanyGameRoles(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameCompany> games = null;
		if (companyService.existsById(id)) {
			Company company = companyService.findById(id);
			games = company.getGames();
			
		} else {
			res.setStatus(404);
			
		}
		
		return games;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET company games by ID
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}/games")
	public List<Game> getCompanyGamesById(
		@PathVariable int id
	) {
		return gameService.getGamesByCompany(id);
	}

	
	
}
