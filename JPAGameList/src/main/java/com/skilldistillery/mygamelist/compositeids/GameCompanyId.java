package com.skilldistillery.mygamelist.compositeids;

import java.io.Serializable;
import java.util.Objects;

public class GameCompanyId implements Serializable {
	private int gameId;
	private int companyId;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameCompanyId() {}
	public GameCompanyId(int gameId, int companyId) {
		super();
		this.gameId = gameId;
		this.companyId = companyId;
	}

	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public int hashCode() {
		return Objects.hash(companyId, gameId);
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
		return companyId == other.companyId && gameId == other.gameId;
	}
	
	@Override
	public String toString() {
		return "GameCompanyId [gameId=" + gameId + ", companyId=" + companyId + "]";
	}
	
	
}
