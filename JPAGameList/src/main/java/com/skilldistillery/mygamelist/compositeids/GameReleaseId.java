package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.Platform;

public class GameReleaseId implements Serializable {
	private Game game;
	private Platform platform;
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameReleaseId() {}
	public GameReleaseId(int gameId, int platformId) {
		super();
		this.game = new Game(gameId);
		this.platform = new Platform(platformId);
	}
	public GameReleaseId(Game game, Platform platform) {
		super();
		this.game = game;
		this.platform = platform;
	}
	
	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(game, platform);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameReleaseId other = (GameReleaseId) obj;
		return Objects.equals(game, other.game) && Objects.equals(platform, other.platform);
	}
	
	@Override
	public String toString() {
		return "GameReleaseId [game=" + game + ", platform=" + platform + "]";
	}
	
	
}
