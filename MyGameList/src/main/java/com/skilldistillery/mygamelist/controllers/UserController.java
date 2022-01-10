package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		GET game by id
	---------------------------------------------------------------------------- */
	@GetMapping("users/{id}")
	public User getUserById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		User user = null;
		try {
			user = userService.findById(id);
			if (user == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return user;
	}
}
