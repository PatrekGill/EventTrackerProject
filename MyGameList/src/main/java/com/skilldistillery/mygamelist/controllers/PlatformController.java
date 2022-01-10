package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;
import com.skilldistillery.mygamelist.services.PlatformService;

@RestController
@RequestMapping("api")
public class PlatformController {
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
		try {
			platform = platformService.findById(id);
			if (platform == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return platform;
	}
	
}
