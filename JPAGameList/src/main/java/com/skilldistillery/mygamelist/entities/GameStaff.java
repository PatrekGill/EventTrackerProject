package com.skilldistillery.mygamelist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.skilldistillery.mygamelist.compositeids.GameStaffId;

@Entity
@Table(name="game_staff")
@IdClass(GameStaffId.class)
public class GameStaff {
	@Id
	@Column(name="game_id")
	private int gameId;
	
	@Id
	@Column(name="staff_id")
	private int staffId;
	
	private String role;
	
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameStaff() {}
	

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
		Get/Set staffId
	---------------------------------------------------------------------------- */
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
		return "GameStaff [gameId=" + gameId + ", staffId=" + staffId + ", role=" + role + "]";
	}
	
	
}
