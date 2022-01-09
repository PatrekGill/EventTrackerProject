package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.entities.User;

public class UserGameId implements Serializable {
	private User user;
	private Game game;
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public UserGameId() {}
	public UserGameId(User user, Game game) {
		super();
		this.user = user;
		this.game = game;
	}

	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(game, user);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGameId other = (UserGameId) obj;
		return Objects.equals(game, other.game) && Objects.equals(user, other.user);
	}
	
	@Override
	public String toString() {
		return "UserGameId [user=" + user + ", game=" + game + "]";
	}
	
	
}
