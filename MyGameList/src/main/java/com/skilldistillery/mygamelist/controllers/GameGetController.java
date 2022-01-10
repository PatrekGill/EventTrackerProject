package com.skilldistillery.mygamelist.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.GameComment;
import com.skilldistillery.mygamelist.entities.GameCompany;
import com.skilldistillery.mygamelist.entities.GameRelation;
import com.skilldistillery.mygamelist.entities.GameRelease;
import com.skilldistillery.mygamelist.entities.GameStaff;
import com.skilldistillery.mygamelist.entities.Platform;
import com.skilldistillery.mygamelist.entities.Staff;
import com.skilldistillery.mygamelist.services.GameCommentService;
import com.skilldistillery.mygamelist.services.GameService;
import com.skilldistillery.mygamelist.services.PlatformService;
import com.skilldistillery.mygamelist.services.StaffService;

@RestController
@RequestMapping("api")
public class GameGetController {
	@Autowired
	private GameService gameService;
	@Autowired
	private PlatformService platformService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private GameCommentService commentService;
	
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
		@PathVariable int id
	) {
		return gameService.getCompaniesByGame(id);
	}
	
	
	/* ----------------------------------------------------------------------------
		GET Platforms For game
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/platforms")
	public List<Platform> getPlatformsForGame(
		@PathVariable int id
	) {
		return platformService.getPlatformsForGame(id);
	}
	
	
	/* ----------------------------------------------------------------------------
		GET Game Relationships
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/relationships")
	public List<GameRelation> getGameRelationships(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameRelation> relations = new ArrayList<>();
		try {
			Game game = gameService.findById(id);
			if (game == null) {
				res.setStatus(404);
				
			} else {
				relations = game.getRelations();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return relations;
	}
	
	/* ----------------------------------------------------------------------------
		GET Game Staff with roles
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/staff/roles")
	public List<GameStaff> getGameStaffWithRoles(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameStaff> gameStaff = new ArrayList<>();
		try {
			Game game = gameService.findById(id);
			if (game == null) {
				res.setStatus(404);
				
			} else {
				gameStaff = game.getStaff();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return gameStaff;
	}
	
	/* ----------------------------------------------------------------------------
		GET Game Releases With platforms
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/releases")
	public List<GameRelease> getGameReleasesWithPlatforms(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameRelease> gameReleases = new ArrayList<>();
		try {
			Game game = gameService.findById(id);
			if (game == null) {
				res.setStatus(404);
				
			} else {
				gameReleases = game.getReleases();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return gameReleases;
	}
	
	/* ----------------------------------------------------------------------------
		GET Game Comments
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/comments")
	public List<GameComment> getAllCommentsOnGame(
		@PathVariable int id
	) {
		return commentService.getNonReplyCommentsOnGame(id);
	}
	
	/* ----------------------------------------------------------------------------
		GET Game Staff
	---------------------------------------------------------------------------- */
	@GetMapping("games/{id}/staff")
	public List<Staff> getGameStaff(
		@PathVariable int id
	) {
		return staffService.getStaffForGameById(id);
	}
}
