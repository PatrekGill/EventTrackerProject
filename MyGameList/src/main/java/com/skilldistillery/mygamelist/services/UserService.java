package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.User;

public interface UserService extends CRUDObject<User, Integer> {
	List<User> findAll();
}
