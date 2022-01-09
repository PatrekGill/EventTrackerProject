package com.skilldistillery.mygamelist.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skilldistillery.mygamelist.compositeids.GameStaffId;

@Entity
@Table(name="game_staff")
@IdClass(GameStaffId.class)
public class GameStaff {
	@Id
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	@Id
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	private String role;
	
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameStaff() {}
	

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
		Get/Set Staff
	---------------------------------------------------------------------------- */
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
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
		return "GameStaff [game=" + game + ", staff=" + staff + ", role=" + role + "]";
	}
	
	
}
