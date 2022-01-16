package com.skilldistillery.mygamelist.controllers.gamecomment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.GameComment;
import com.skilldistillery.mygamelist.services.gamecomment.GameCommentService;

@RestController
@RequestMapping("api")
public class GameCommentGetController {
	@Autowired
	private GameCommentService commentService;

	/* ----------------------------------------------------------------------------
		GET comment by Id
	---------------------------------------------------------------------------- */
	@GetMapping("GameComment/{id}")
	public GameComment getCommentById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		GameComment comment = null;
		if (commentService.existsById(id)) {
			comment = commentService.findById(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return comment;
	}
	
	/* ----------------------------------------------------------------------------
		GET comment replies
	---------------------------------------------------------------------------- */
	@GetMapping("GameComment/{id}/replies")
	public List<GameComment> getCommentRepliesById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		List<GameComment> replies = null;
		if (commentService.existsById(id)) {
			replies = commentService.getCommentReplies(id);
			
		} else {
			res.setStatus(404);
			
		}
		
		return replies;
	}
	
	/* ----------------------------------------------------------------------------
		GET repliedComment by Id
	---------------------------------------------------------------------------- */
	@GetMapping("GameComment/{id}/replyTo")
	public GameComment getCommentReplyById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		GameComment comment = null;
		if (commentService.existsById(id)) {
			GameComment originalComment = commentService.findById(id);
			comment = originalComment.getReplyToComment();
			if (comment == null) {
				res.setStatus(404);
			}
			
		} else {
			res.setStatus(404);
			
		}
		
		return comment;
	}
	
	
}
