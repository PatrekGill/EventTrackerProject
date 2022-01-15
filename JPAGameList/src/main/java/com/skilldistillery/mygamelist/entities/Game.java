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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.SpringUpdate;

@Entity
public class Game {
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
    @OneToMany(mappedBy = "game")
    private List<GameCompany> companies;
    
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<GameStaff> staff;
    
    @ManyToMany(mappedBy="games")
    private List<Tag> tags;
    
    @JsonIgnore
    @OneToMany(mappedBy="primaryGame")
    private List<GameRelation> relations;
    
    @JsonIgnore
    @OneToMany(mappedBy="game")
    private List<GameRelease> releases;
    
    @JsonIgnore
    @OneToMany(mappedBy="game")
    @OrderBy("created_date_time DESC") // most recent first
    private List<GameComment> comments;
    
    @SpringUpdate
	private String description;
    @SpringUpdate
	private String title;
	
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public Game() {}
	public Game(int id) {
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
		Get/Set Title
	---------------------------------------------------------------------------- */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		Get/Set description
	---------------------------------------------------------------------------- */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	/* ----------------------------------------------------------------------------
		Get/Set Companies
	---------------------------------------------------------------------------- */
	public List<GameCompany> getCompanies() {
		if (companies == null) {
			companies = new ArrayList<GameCompany>();
		}
		
		return companies;
	}
	public void setCompanies(List<GameCompany> companies) {
		this.companies = companies;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Staff
	---------------------------------------------------------------------------- */
	public List<GameStaff> getStaff() {
		if (staff == null) {
			staff = new ArrayList<GameStaff>();
		}
		
		return staff;
	}
	public void setStaff(List<GameStaff> staff) {
		this.staff = staff;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Relations
	---------------------------------------------------------------------------- */
	public List<GameRelation> getRelations() {
		if (relations == null) {
			relations = new ArrayList<>();
		}
		
		return relations;
	}
	public void setRelations(List<GameRelation> relations) {
		this.relations = relations;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Tags
	---------------------------------------------------------------------------- */
	public List<Tag> getTags() {
		if (tags == null) {
			tags = new ArrayList<>();
		}
		
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
		Get/Set Comments
	---------------------------------------------------------------------------- */
	public List<GameComment> getComments() {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		
		return comments;
	}
	public void setComments(List<GameComment> comments) {
		this.comments = comments;
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
		Game other = (Game) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + "]";
	}
	
	
}
