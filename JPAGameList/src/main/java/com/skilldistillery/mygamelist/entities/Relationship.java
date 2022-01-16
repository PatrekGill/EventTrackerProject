package com.skilldistillery.mygamelist.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.skilldistillery.mygamelist.SpringUpdate;

@Entity
public class Relationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@SpringUpdate
	private String name;

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public Relationship() {}
	
	
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
		Relationship other = (Relationship) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Relationship [id=" + id + ", name=" + name + "]";
	}
	
}
