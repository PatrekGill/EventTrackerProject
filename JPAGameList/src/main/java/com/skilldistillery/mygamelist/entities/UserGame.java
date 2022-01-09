package com.skilldistillery.mygamelist.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_game")
public class UserGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;

	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@Column(name="start_date")
    private LocalDate startDate;
	
	@Column(name="finish_date")
	private LocalDate finishDate;

	@Column(name="hours_played")
	private double hoursPlayed;
	
	private String notes;
	private int score;

	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public UserGame() {}
	

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
		Get/Set User
	---------------------------------------------------------------------------- */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		Get/Set Status
	---------------------------------------------------------------------------- */
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Start Date
	---------------------------------------------------------------------------- */
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Finish Date
	---------------------------------------------------------------------------- */
	public LocalDate getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Hours Played
	---------------------------------------------------------------------------- */
	public double getHoursPlayed() {
		return hoursPlayed;
	}
	public void setHoursPlayed(double hoursPlayed) {
		this.hoursPlayed = hoursPlayed;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Notes
	---------------------------------------------------------------------------- */
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Score
	---------------------------------------------------------------------------- */
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
		UserGame other = (UserGame) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "UserGame [id=" + id + ", user=" + user + ", game=" + game + "]";
	}
	
	
}
