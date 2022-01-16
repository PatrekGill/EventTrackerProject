package com.skilldistillery.mygamelist.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.SpringUpdate;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
		name = "game_tag",
		joinColumns = @JoinColumn(name="tag_id"),
		inverseJoinColumns = @JoinColumn(name="game_id") 
    )
	private List<Game> games;
	
	@SpringUpdate
	private String name;

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public Tag() {}
	
	
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
		Get/Set Name
	---------------------------------------------------------------------------- */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/* ----------------------------------------------------------------------------
		Get/Set Games
	---------------------------------------------------------------------------- */
	public List<Game> getGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
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
		Tag other = (Tag) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + "]";
	}
	
}
