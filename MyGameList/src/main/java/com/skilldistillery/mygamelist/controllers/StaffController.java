package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;
import com.skilldistillery.mygamelist.services.StaffService;

@RestController
@RequestMapping("api")
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	/* ----------------------------------------------------------------------------
		GET all staff
	---------------------------------------------------------------------------- */
	@GetMapping("staff")
	public List<Staff> index() {
		return staffService.findAll();
	}
	
	/* ----------------------------------------------------------------------------
		GET staff by id
	---------------------------------------------------------------------------- */
	@GetMapping("staff/{id}")
	public Staff getStaffById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Staff staff = null;
		try {
			staff = staffService.findById(id);
			if (staff == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return staff;
	}
	
	
	/* ----------------------------------------------------------------------------
		GET staff games by id
	---------------------------------------------------------------------------- */
	@GetMapping("staff/{id}/games")
	public List<Game> getStaffGamesById(
		@PathVariable int id
	) {
		return staffService.getGamesForStaffById(id);
	}
}
