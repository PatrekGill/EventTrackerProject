package com.skilldistillery.mygamelist.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skilldistillery.mygamelist.CompositeId;
import com.skilldistillery.mygamelist.SpringUpdate;
import com.skilldistillery.mygamelist.compositeids.GameCompanyId;

@Entity
@IdClass(GameCompanyId.class)
@Table(name="game_company")
public class GameCompany implements CompositeId<GameCompanyId> {
	@Id
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	@Id
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@SpringUpdate
	private String role;
	
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameCompany() {}
	

	/* ----------------------------------------------------------------------------
		Get GameCompanyId
	---------------------------------------------------------------------------- */
	@Override
	public GameCompanyId getId() {
		return new GameCompanyId(game,company);
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Game
	---------------------------------------------------------------------------- */
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Company
	---------------------------------------------------------------------------- */
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	/* ----------------------------------------------------------------------------
		Get/Set role
	---------------------------------------------------------------------------- */
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "GameCompany [game=" + game + ", company=" + company + ", role=" + role + "]";
	}

}
