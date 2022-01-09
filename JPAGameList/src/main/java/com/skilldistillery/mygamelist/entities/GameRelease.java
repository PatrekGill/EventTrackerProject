package com.skilldistillery.mygamelist.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_release")
public class GameRelease {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="platform_id")
	private Platform platform;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	private LocalDate date;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameRelease() {}
	

	/* ----------------------------------------------------------------------------
		Get/Set ID
	---------------------------------------------------------------------------- */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameRelease other = (GameRelease) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", platform=" + platform + ", game=" + game + ", date=" + date + "]";
	}
	
}
