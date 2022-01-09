package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

public class GameStaffId implements Serializable {
	private int gameId;
	private int staffId;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameStaffId() {}
	public GameStaffId(int gameId, int staffId) {
		super();
		this.gameId = gameId;
		this.staffId = staffId;
	}
	
	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(gameId, staffId);
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
		return gameId == other.gameId && staffId == other.staffId;
	}
	
	@Override
	public String toString() {
		return "GameStaffId [gameId=" + gameId + ", staffId=" + staffId + "]";
	}
	
	
}
