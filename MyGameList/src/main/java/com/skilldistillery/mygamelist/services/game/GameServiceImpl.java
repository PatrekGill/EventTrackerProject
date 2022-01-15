package com.skilldistillery.mygamelist.services.game;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.SpringUpdate;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	@Autowired
	private GameRepository gameRepo;
	@Autowired
	private OptionalRetriever<Game> gameRetriever;
	
	@Override
	public List<Game> findAll() {
		return gameRepo.findAll();
	}
	
	@Override
	public Game findById(Integer id) {
		return gameRetriever.get(
			gameRepo.findById(id)
		);
	}
	
	@Override
	public List<Game> getGamesByCompany(int companyID) {
		return gameRepo.findDistnctByCompanies_game_id(companyID);
	}

	@Override
	public List<Company> getCompaniesByGame(int gameID) {
		return gameRepo.findDistnctByCompanies_company_id(gameID);
	}

	@Override
	public Game create(Game game) {
		return gameRepo.saveAndFlush(game);
	}

	@Override
	public List<Game> findByTitleLike(String keyword) {
		return gameRepo.findByTitleLike("%" + keyword + "%");
	}

	@Override
	public Game update(Integer id,Game game) {
		Game managedGame = findById(id);
//		if (managedGame != null) {
//			managedGame.setTitle(game.getTitle());
//			managedGame.setDescription(game.getDescription());
//			managedGame.setImageURL(game.getImageURL());
//			
//			gameRepo.saveAndFlush(managedGame);
//		}
		if (managedGame != null) {
			try {
				for(Field field : Game.class.getDeclaredFields())
				{
					if (field.isAnnotationPresent(SpringUpdate.class))
					{
						PropertyDescriptor desc = new PropertyDescriptor(field.getName(), Game.class);
						Object newValue = desc.getReadMethod().invoke(game);
						desc.getWriteMethod().invoke(managedGame,newValue);
					}
				}
				
				gameRepo.saveAndFlush(managedGame);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Failed to update entity with id: " + id);
			}
			
//			Object thing = Double.valueOf(1.0);
//			test(thing);
		}
		
		return managedGame;
	}
	
	public void test(double num) {
		
	}
	
	@Override
	public boolean existsById(Integer id) {
		return gameRepo.existsById(id);
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean deleted = false;
		try {
			gameRepo.deleteById(id);
			if (!existsById(id)) {
				deleted = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return deleted;
	}
	
	
}
