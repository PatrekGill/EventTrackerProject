package com.skilldistillery.mygamelist.services.status;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Status;

public interface StatusService {
	List<Status> findAll();
	Status findById(int id);
	boolean existsById(int id);
}
