package com.skilldistillery.mygamelist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	List<Tag> findByNameLike(String name);
}
