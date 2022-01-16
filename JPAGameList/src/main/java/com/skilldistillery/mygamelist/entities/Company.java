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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@SpringUpdate
	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="updated_date_time")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
	
    @Column(name = "created_date_time")
	@CreationTimestamp
	private LocalDateTime createdDateTime;
    
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<GameCompany> games;
    
    @SpringUpdate
    private String name;
    @SpringUpdate
    private String description;
    

	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public Company() {}
	public Company(int id) {
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
		Get/Set description
	---------------------------------------------------------------------------- */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	/* ----------------------------------------------------------------------------
		Get/Set imageURL
	---------------------------------------------------------------------------- */
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
		Get/Set Games
	---------------------------------------------------------------------------- */
	public List<GameCompany> getGames() {
		if (games == null) {
			games = new ArrayList<>();
		}
		return games;
	}
	public void setGames(List<GameCompany> games) {
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
		Company other = (Company) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
	
}
