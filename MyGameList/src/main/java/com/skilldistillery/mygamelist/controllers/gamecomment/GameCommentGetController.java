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
	
	
	/* ----------------------------------------------------------------------------
		POST create new comment
	---------------------------------------------------------------------------- */
	@PostMapping("GameComment")
	public GameComment createComment(
		@RequestBody GameComment comment,
		HttpServletResponse res,
		HttpServletRequest req
	) {
		
		try {
			comment = commentService.create(comment);
			res.setStatus(201);
			
			StringBuffer url = req.getRequestURL();
			url.append("/").append(comment.getId());
			res.setHeader("Location",url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid comment sent to create");
			res.setStatus(400);
			comment = null;
			
		}
		
		return comment;
	}
	

	/* ----------------------------------------------------------------------------
		PUT update comment
	---------------------------------------------------------------------------- */
	@PutMapping("GameComment/{id}")
	public GameComment updateComment(
		@PathVariable int id,
		@RequestBody GameComment comment,
		HttpServletResponse res
	) {
		try {
			comment = commentService.update(id, comment);
			if (comment == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid game sent to update");
			res.setStatus(400);
			comment = null;
			
		}
		
		return comment;
	}
	
	/* ----------------------------------------------------------------------------
		POST reply to comment
	---------------------------------------------------------------------------- */
	@PostMapping("GameComment/{id}")
	public GameComment replyToComment(
		@PathVariable int id,
		@RequestBody GameComment comment,
		HttpServletResponse res,
		HttpServletRequest req
	) {
		try {
			if (commentService.existsById(id)) {
				GameComment repliedToComment = commentService.findById(id);
				comment.setReplyToComment(repliedToComment);
				
				comment = commentService.create(comment);
				res.setStatus(201);
				
				StringBuffer url = req.getRequestURL();
				url.append("/").append(comment.getId());
				res.setHeader("Location",url.toString());
				
			} else {
				res.setStatus(404);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid comment sent to create");
			res.setStatus(400);
			comment = null;
			
		}
		
		
		return comment;
	}
	

	/* ----------------------------------------------------------------------------
		DELETE comment
	---------------------------------------------------------------------------- */
	@DeleteMapping("GameComment/{id}")
	public void deleteComment(
		@PathVariable int id,
		HttpServletResponse res
	) {
		if (commentService.existsById(id)) {
			if (commentService.deleteById(id)) {
				res.setStatus(204);
				
			} else {
				res.setStatus(409);
				
			}
			
		} else {
			res.setStatus(404);
			
		}
		
	}
}
