package com.skilldistillery.mygamelist.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.CompositeId;
import com.skilldistillery.mygamelist.SpringUpdate;
import com.skilldistillery.mygamelist.compositeids.GameCompanyId;
import com.skilldistillery.mygamelist.compositeids.GameReleaseId;

@Entity
@IdClass(GameReleaseId.class)
@Table(name="game_release")
public class GameRelease implements CompositeId<GameReleaseId> {
	@Id
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;

	@Id
	@ManyToOne
	@JoinColumn(name="platform_id")
	private Platform platform;
	
	@SpringUpdate
	private LocalDate date;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameRelease() {}

	
	/* ----------------------------------------------------------------------------
		Get GameReleaseId
	---------------------------------------------------------------------------- */
	@Override
	public GameReleaseId getId() {
		return new GameReleaseId(game,platform);
	}

	
	/* ----------------------------------------------------------------------------
		Get/Set platform
	---------------------------------------------------------------------------- */
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}


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
		Get/Set Date
	---------------------------------------------------------------------------- */
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}


	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "GameRelease [game=" + game + ", platform=" + platform + ", date=" + date + "]";
	}
	
}
