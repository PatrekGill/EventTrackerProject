package com.skilldistillery.mygamelist.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.SpringUpdate;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="updated_date_time")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
	
    @Column(name = "created_date_time")
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<GameList> gameLists;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<UserGame> gamesOnList;
    
    @SpringUpdate
	private String password;
    @SpringUpdate
	private String username;
	

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public User() {}
	public User(int id) {
		this.id = id;
	}
	

	/* ----------------------------------------------------------------------------
		Get/Set GameLists
	---------------------------------------------------------------------------- */
	public List<GameList> getGameLists() {
		if (gameLists == null) {
			gameLists = new ArrayList<>();
		}
		return gameLists;
	}
	public void setGameLists(List<GameList> gameLists) {
		this.gameLists = gameLists;
	}

	
	/* ----------------------------------------------------------------------------
		Get/Set gamesOnList
	---------------------------------------------------------------------------- */
	public List<UserGame> getGamesOnList() {
		if (gamesOnList == null) {
			gamesOnList = new ArrayList<>();
		}
		return gamesOnList;
	}
	public void setGamesOnList(List<UserGame> gamesOnList) {
		this.gamesOnList = gamesOnList;
	}
	
	
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
		Get/Set updateDateTime
	---------------------------------------------------------------------------- */
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}


	/* ----------------------------------------------------------------------------
		Get/Set createdDateTime
	---------------------------------------------------------------------------- */
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}



	/* ----------------------------------------------------------------------------
		Get/Set pssword
	---------------------------------------------------------------------------- */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	/* ----------------------------------------------------------------------------
		Get/Set username
	---------------------------------------------------------------------------- */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		User other = (User) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", createdDateTime=" + createdDateTime + ", username=" + username + "]";
	}
	
	
}
