package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
	
}
