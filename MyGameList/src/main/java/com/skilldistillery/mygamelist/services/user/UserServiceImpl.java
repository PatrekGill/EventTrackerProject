package com.skilldistillery.mygamelist.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.User;
import com.skilldistillery.mygamelist.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private OptionalRetriever<User> retriever;

	@Override
	public JpaRepository<User, Integer> getRepo() {
		return userRepo;
	}
	@Override
	public OptionalRetriever<User> getRetriever() {
		return retriever;
	}
	
}
