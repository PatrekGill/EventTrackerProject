package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.User;

public interface UserService {
	List<User> findAll();
	User findById(int id);
	boolean existsById(int id);
}
