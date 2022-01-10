package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.GameComment;
import com.skilldistillery.mygamelist.repositories.GameCommentRepository;

@Service
public class GameCommentServiceImpl implements GameCommentService {
	@Autowired
	private GameCommentRepository commentRepo;
	@Autowired
	private OptionalRetriever<GameComment> commentRetriever;


	@Override
	public GameComment findById(int id) {
		return commentRetriever.get(
			commentRepo.findById(id)
		);
	}
	
	@Override
	public List<GameComment> getNonReplyCommentsOnGame(int id) {
		return commentRepo.getVisibleAndNonReplyingCommentsOnGameById(id);
	}

	@Override
	public GameComment create(GameComment comment) {
		if (!comment.isVisible()) {
			comment.setVisible(true);
		}
		
		return commentRepo.saveAndFlush(comment);
	}

	@Override
	public GameComment update(int id, GameComment comment) {
		GameComment managed = findById(id);
		if (managed != null) {
			managed.setText(comment.getText());
			commentRepo.saveAndFlush(managed);
		}
		
		return managed;
	}
	
	@Override
	public boolean existsById(int id) {
		return commentRepo.existsById(id);
	}
	
	@Override
	public boolean delete(int id) {
		boolean deleted = false;
		if (existsById(id)) {
			GameComment comment = findById(id);
			comment.setVisible(false);
			
			List<GameComment> replies = comment.getReplies();
			if (!replies.isEmpty() ) {
				for (int i = 0; i < replies.size(); i++) {
					replies.get(i).setVisible(false);
				}
				
			}
			
			deleted = true;
			commentRepo.saveAndFlush(comment);
		}
		
		return deleted;
	}

	@Override
	public List<GameComment> getCommentReplies(int id) {
		return commentRepo.getVisibleCommentReplies(id);
	}
}
