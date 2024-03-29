package com.skilldistillery.mygamelist.controllers.platform;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;
import com.skilldistillery.mygamelist.services.platform.PlatformService;

@RestController
@RequestMapping("api")
public class PlatformGetController {
	@Autowired
	private PlatformService platformService;

	/* ----------------------------------------------------------------------------
		GET all Platforms
	---------------------------------------------------------------------------- */
	@GetMapping("platforms")
	public List<Platform> index() {
		return platformService.findAll();
	}
	
	/* ----------------------------------------------------------------------------
		GET Platform by id
	---------------------------------------------------------------------------- */
	@GetMapping("platforms/{id}")
	public Platform getPlatformById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Platform platform = null;
		if (platformService.existsById(id)) {
			platform = platformService.findById(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return platform;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET Games For Platform
	---------------------------------------------------------------------------- */
	@GetMapping("platforms/{id}/games")
	public List<Game> getGamesForPlatform(
		@PathVariable int id,
		HttpServletResponse res
	) {
		return platformService.getGamesForPlatform(id);
	}
	
}
