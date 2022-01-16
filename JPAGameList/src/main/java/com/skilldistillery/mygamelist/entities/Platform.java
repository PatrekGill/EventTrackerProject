package com.skilldistillery.mygamelist.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.SpringUpdate;

@Entity
public class Platform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "platform")
	List<GameRelease> releases;
	
	@SpringUpdate
	private String name;
	
	@SpringUpdate
	private String abbreviation;

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public Platform() {}
	public Platform(int id) {
		this.id = id;
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
		Get/Set Name
	---------------------------------------------------------------------------- */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Abbreviation
	---------------------------------------------------------------------------- */
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	

	/* ----------------------------------------------------------------------------
		Get/Set Releases
	---------------------------------------------------------------------------- */
	public List<GameRelease> getReleases() {
		if (releases == null) {
			releases = new ArrayList<>();
		}
		
		return releases;
	}
	public void setReleases(List<GameRelease> releases) {
		this.releases = releases;
	}


	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		return id == other.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Platform [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + "]";
	}
	
}
