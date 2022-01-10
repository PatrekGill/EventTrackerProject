package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Status;
import com.skilldistillery.mygamelist.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusRepository statusRepo;
	@Autowired
	private OptionalRetriever<Status> statusRetriever;

	@Override
	public List<Status> findAll() {
		return statusRepo.findAll();
	}

	@Override
	public Status findById(int id) {
		return statusRetriever.get(
			statusRepo.findById(id)
		);
	}
	
	
}
