package com.skilldistillery.mygamelist.entities;

import java.io.Serializable;
import java.util.Objects;

public class GameRelationId implements Serializable {
	private Game primaryGame;
	private Game otherGame;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameRelationId() {}
	public GameRelationId(Game primaryGame, Game otherGame) {
		super();
		this.primaryGame = primaryGame;
		this.otherGame = otherGame;
	}
	

	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(otherGame, primaryGame);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameRelationId other = (GameRelationId) obj;
		return otherGame == other.otherGame && primaryGame == other.primaryGame;
	}
	
	@Override
	public String toString() {
		return "GameRelationId [primaryGame=" + primaryGame + ", otherGame=" + otherGame + "]";
	}
	
	
}
