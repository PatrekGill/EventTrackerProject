package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.GameList;
import com.skilldistillery.mygamelist.entities.User;
import com.skilldistillery.mygamelist.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	private UserService userService;
	
	/* ----------------------------------------------------------------------------
		GET all Users
	---------------------------------------------------------------------------- */
	@GetMapping("users")
	public List<User> index() {
		return userService.findAll();
	}
	
	/* ----------------------------------------------------------------------------
		GET user by id
	---------------------------------------------------------------------------- */
	@GetMapping("users/{id}")
	public User getUserById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		User user = null;
		if (userService.existsById(id)) {
			user = userService.findById(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return user;
	}
	
	/* ----------------------------------------------------------------------------
		GET user's GameLists by id
	---------------------------------------------------------------------------- */
	@GetMapping("users/{id}/gamelists")
	public List<GameList> getUserGameListsById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameList> gameLists = null;
		if (userService.existsById(id)) {
			User user = userService.findById(id);
			gameLists = user.getGameLists();
			
		} else {
			res.setStatus(404);
			
		}
		
		return gameLists;
	}
}
