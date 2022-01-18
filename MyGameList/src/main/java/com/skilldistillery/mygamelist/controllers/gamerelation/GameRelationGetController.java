package com.skilldistillery.mygamelist.controllers.gamerelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.services.gamerelation.GameRelationService;

@RestController
@RequestMapping("api")
public class GameRelationGetController {
	@Autowired
	private GameRelationService relationService;
	
}
