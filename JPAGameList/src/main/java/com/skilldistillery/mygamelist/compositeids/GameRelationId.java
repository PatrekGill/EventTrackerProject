package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

import com.skilldistillery.mygamelist.entities.Game;

public class GameRelationId implements Serializable {
	private Game primaryGame;
	private Game otherGame;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameRelationId() {}
	public GameRelationId(int primaryGameId, int otherGameId) {
		super();
		this.primaryGame = new Game(primaryGameId);
		this.otherGame = new Game(otherGameId);
	}
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
