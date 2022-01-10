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
import com.skilldistillery.mygamelist.services.CompanyService;
import com.skilldistillery.mygamelist.services.GameService;

@RestController
@RequestMapping("api")
public class CompanyController {
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
		try {
			company = companyService.findById(id);
			if (company == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return company;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET company games and roles by ID
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}/gameroles")
	public List<GameCompany> getCompanyGameRoles(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameCompany> games = null;
		try {
			Company company = companyService.findById(id);
			if (company == null) {
				res.setStatus(404);
				
			} else {
				games = company.getGames();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return games;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET company games by ID
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}/games")
	public List<Game> getCompanyGamesById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<Game> games = null;
		try {
			games = gameService.getGamesByCompany(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return games;
	}

	
	
}
