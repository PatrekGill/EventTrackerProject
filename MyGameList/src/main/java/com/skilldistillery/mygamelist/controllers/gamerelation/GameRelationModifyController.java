package com.skilldistillery.mygamelist.controllers.gamerelation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.compositeids.GameRelationId;
import com.skilldistillery.mygamelist.entities.GameRelation;
import com.skilldistillery.mygamelist.services.gamerelation.GameRelationService;

@RestController
@RequestMapping("api")
public class GameRelationModifyController {
	@Autowired
	private GameRelationService relationService;
	
	/* ----------------------------------------------------------------------------
		POST create game relationship
	---------------------------------------------------------------------------- */
	@PostMapping("gamerelation")
	public GameRelation createRelation(
		@RequestBody GameRelation relation,
		HttpServletResponse res
	) {
		try {
			relation = relationService.create(relation);
			res.setStatus(201);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to create game relation");
			res.setStatus(400);
			relation = null;
		}
		
		return relation;
	}
	
	/* ----------------------------------------------------------------------------
		PUT update relation
	---------------------------------------------------------------------------- */
	@PutMapping("gamerelation")
	public GameRelation updateRelation(
		@RequestBody GameRelation relation,
		HttpServletResponse res
	) {
		
		try {
			GameRelationId id = new GameRelationId(
				relation.getPrimaryGame(),
				relation.getOtherGame()
			);
			relation = relationService.update(id, relation, gr -> true);
			res.setStatus(201);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to update game relation");
			res.setStatus(400);
			relation = null;
		}
		
		return relation;
	}
	

	/* ----------------------------------------------------------------------------
		DELETE game
	---------------------------------------------------------------------------- */
	@DeleteMapping("gamerelation/{primaryGameId}/{otherGameId}")
	public void deleteRelation(
		@PathVariable int primaryGameId,
		@PathVariable int otherGameId,
		HttpServletResponse res
	) {
		GameRelationId id = new GameRelationId(primaryGameId,otherGameId);
		if (relationService.existsById(id)) {
			if (relationService.deleteById(id, gr -> true)) {
				res.setStatus(204);
				
			} else {
				res.setStatus(409);
				
			}
			
		} else {
			res.setStatus(404);
			
		}
		
	}
}
