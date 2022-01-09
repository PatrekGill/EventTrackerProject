package com.skilldistillery.mygamelist.entities;

import java.io.Serializable;
import java.util.Objects;

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