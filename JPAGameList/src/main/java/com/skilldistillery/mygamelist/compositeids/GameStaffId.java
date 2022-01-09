package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Staff;

public class GameStaffId implements Serializable {
	private Game game;
	private Staff staff;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameStaffId() {}
	public GameStaffId(Game game, Staff staff) {
		super();
		this.game = game;
		this.staff = staff;
	}
	
	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(game, staff);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameStaffId other = (GameStaffId) obj;
		return Objects.equals(game, other.game) && Objects.equals(staff, other.staff);
	}
	
	@Override
	public String toString() {
		return "GameStaffId [game=" + game + ", staff=" + staff + "]";
	}
	
	
	
	
}
