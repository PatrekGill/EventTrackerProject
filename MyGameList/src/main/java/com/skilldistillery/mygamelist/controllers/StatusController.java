package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Status;
import com.skilldistillery.mygamelist.services.StatusService;

@RestController
@RequestMapping("api")
public class StatusController {
	@Autowired
	private StatusService statusService;

	/* ----------------------------------------------------------------------------
		GET all statuses
	---------------------------------------------------------------------------- */
	@GetMapping("status")
	public List<Status> index() {
		return statusService.findAll();
	}
	
	/* ----------------------------------------------------------------------------
		GET status by id
	---------------------------------------------------------------------------- */
	@GetMapping("status/{id}")
	public Status getStatusById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Status status = null;
		try {
			status = statusService.findById(id);
			if (status == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return status;
	}
}
