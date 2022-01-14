package com.skilldistillery.mygamelist.controllers.gamecompany;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.entities.GameCompany;
import com.skilldistillery.mygamelist.services.gamecompany.GameCompanyService;

@RestController
@RequestMapping("api")
public class GameCompanyGetController {
	@Autowired
	private GameCompanyService gcService;
	
	/* ----------------------------------------------------------------------------
		GET all games
	---------------------------------------------------------------------------- */
	@GetMapping(path={
			"game/{gameId}/company/{companyId}",
			"company/{companyId}/game/{gameId}"			
		}
	)
	public GameCompany getByGameIdAndCompanyId(
		@PathVariable int gameId,
		@PathVariable int companyId,
		HttpServletResponse res
	) {
		GameCompany gc = null;
		GameCompanyId id = new GameCompanyId(gameId,companyId); 
		if (gcService.existsById(id)) {
			gc = gcService.findById(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return gc;
	}
}
