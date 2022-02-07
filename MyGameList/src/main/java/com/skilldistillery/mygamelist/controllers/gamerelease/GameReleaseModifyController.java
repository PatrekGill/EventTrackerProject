package com.skilldistillery.mygamelist.controllers.gamerelease;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.compositeids.GameReleaseId;
import com.skilldistillery.mygamelist.entities.GameRelease;
import com.skilldistillery.mygamelist.services.gamerelease.GameReleaseService;

@RestController
@RequestMapping("api")
public class GameReleaseModifyController {
	@Autowired
	private GameReleaseService releaseService;
	

	/* ----------------------------------------------------------------------------
		POST create game relationship
	---------------------------------------------------------------------------- */
	@PostMapping("gamerelease")
	public GameRelease createRelease(
		@RequestBody GameRelease release,
		HttpServletResponse res
	) {
		try {
			release = releaseService.create(release);
			res.setStatus(201);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to create game release");
			res.setStatus(400);
			release = null;
		}
		
		return release;
	}
	
	/* ----------------------------------------------------------------------------
		PUT update relation
	---------------------------------------------------------------------------- */
	@PutMapping("gamerelease")
	public GameRelease updateRelease(
		@RequestBody GameRelease release,
		HttpServletResponse res
	) {
		
		try {
			GameReleaseId id = new GameReleaseId(
				release.getGame(),
				release.getPlatform()
			);
			release = releaseService.update(id, release, gr -> true);
			res.setStatus(201);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to update game release");
			res.setStatus(400);
			release = null;
		}
		
		return release;
	}
	

	/* ----------------------------------------------------------------------------
		DELETE game
	---------------------------------------------------------------------------- */
	@DeleteMapping("gamerelation/{gameId}/{platformId}")
	public void deleteRelease(
		@PathVariable int gameId,
		@PathVariable int platformId,
		HttpServletResponse res
	) {
		GameReleaseId id = new GameReleaseId(gameId,platformId);
		if (releaseService.existsById(id)) {
			if (releaseService.deleteById(id, gr -> true)) {
				res.setStatus(204);
				
			} else {
				res.setStatus(409);
				
			}
			
		} else {
			res.setStatus(404);
			
		}
		
	}
}
