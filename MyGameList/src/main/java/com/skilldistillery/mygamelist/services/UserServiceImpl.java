package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.User;
import com.skilldistillery.mygamelist.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private OptionalRetriever<User> userRetriever;
	
	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	@Override
	public User findById(Integer id) {
		return userRetriever.get(
			userRepo.findById(id)
		);
	}
	
	@Override
	public boolean existsById(Integer id) {
		return userRepo.existsById(id);
	}

	@Override
	public User create(User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(Integer id, User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
