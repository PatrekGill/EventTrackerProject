package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
