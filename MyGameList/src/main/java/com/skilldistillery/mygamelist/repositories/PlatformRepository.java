package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
	
}
