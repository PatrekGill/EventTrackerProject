package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Platform;

public interface PlatformService {
	List<Platform> findAll();
	Platform findById(int id);
}
