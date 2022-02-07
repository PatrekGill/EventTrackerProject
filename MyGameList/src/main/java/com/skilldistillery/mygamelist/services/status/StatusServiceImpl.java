package com.skilldistillery.mygamelist.services.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Status;
import com.skilldistillery.mygamelist.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusRepository repo;
	@Autowired
	private OptionalRetriever<Status> retriever;
	
	@Override
	public JpaRepository<Status, Integer> getRepo() {
		return repo;
	}
	@Override
	public OptionalRetriever<Status> getRetriever() {
		return retriever;
	}
	
	
}
