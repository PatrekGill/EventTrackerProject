package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;

public class GameCompanyId implements Serializable {
	private Game game;
	private Company company;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameCompanyId() {}
	public GameCompanyId(Game game, Company company) {
		super();
		this.game = game;
		this.company = company;
	}
	public GameCompanyId(int gameId, int companyId) {
		super();
		this.game = new Game(gameId);
		this.company = new Company(companyId);
	}

	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(company, game);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCompanyId other = (GameCompanyId) obj;
		return Objects.equals(company, other.company) && Objects.equals(game, other.game);
	}
	
	@Override
	public String toString() {
		return "GameCompanyId [game=" + game + ", company=" + company + "]";
	}
	
}
