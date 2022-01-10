package com.skilldistillery.mygamelist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.services.GameCommentService;

@RestController
@RequestMapping("api")
public class GameCommentController {
	@Autowired
	private GameCommentService commentService;
	
	
	/* ----------------------------------------------------------------------------
		POST create comment
	---------------------------------------------------------------------------- */
}
