package com.skilldistillery.mygamelist.services.gamecomment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.GameComment;
import com.skilldistillery.mygamelist.repositories.GameCommentRepository;

@Service
public class GameCommentServiceImpl implements GameCommentService {
	@Autowired
	private GameCommentRepository commentRepo;
	@Autowired
	private OptionalRetriever<GameComment> retriever;
	@Override
	public JpaRepository<GameComment, Integer> getRepo() {
		return commentRepo;
	}
	@Override
	public OptionalRetriever<GameComment> getRetriever() {
		return retriever;
	}
	
	
	@Override
	public List<GameComment> getNonReplyCommentsOnGame(int id) {
		return commentRepo.getVisibleAndNonReplyingCommentsOnGameById(id);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return commentRepo.existsById(id);
	}
	
	@Override
	public boolean deleteById(Integer id) {
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
