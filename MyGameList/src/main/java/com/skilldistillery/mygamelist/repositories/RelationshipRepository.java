package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
	
}
