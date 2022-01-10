package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Status;

public interface StatusService {
	List<Status> findAll();
	Status findById(int id);
}
