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
}
