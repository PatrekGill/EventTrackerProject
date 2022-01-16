package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.compositeids.GameRelationId;
import com.skilldistillery.mygamelist.entities.GameRelation;

public interface GameRelationRepository extends JpaRepository<GameRelation, GameRelationId> {

}
