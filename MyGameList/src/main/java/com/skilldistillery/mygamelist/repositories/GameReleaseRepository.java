package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.compositeids.GameReleaseId;
import com.skilldistillery.mygamelist.entities.GameRelease;

public interface GameReleaseRepository extends JpaRepository<GameRelease, GameReleaseId> {

}
