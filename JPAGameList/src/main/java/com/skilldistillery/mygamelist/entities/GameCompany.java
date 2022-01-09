package com.skilldistillery.mygamelist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.skilldistillery.mygamelist.compositeids.GameCompanyId;

@Entity
@IdClass(GameCompanyId.class)
@Table(name="game_company")
public class GameCompany {
	@Id
	@Column(name="game_id")
	private int gameId;
	
	@Id
	@Column(name="company_id")
	private int companyId;
	
	private String role;
	
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameCompany() {}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set gameId
	---------------------------------------------------------------------------- */
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set companyId
	---------------------------------------------------------------------------- */
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
		return "GameCompany [gameId=" + gameId + ", companyId=" + companyId + ", role=" + role + "]";
	}
}
