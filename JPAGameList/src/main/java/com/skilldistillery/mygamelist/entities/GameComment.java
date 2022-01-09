package com.skilldistillery.mygamelist.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game_comment")
public class GameComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="updated_date_time")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
	
    @Column(name = "created_date_time")
	@CreationTimestamp
	private LocalDateTime createdDateTime;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="in_reply_to")
    private GameComment replyToComment;
    
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
    
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="in_reply_to")
    @OrderBy("created_date_time DESC") // most recent
    private List<GameComment> replies;

    private boolean visible;
    private String text;
    
    
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameComment() {}
	
	
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
		Get/Set User
	---------------------------------------------------------------------------- */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	/* ----------------------------------------------------------------------------
		Get/Set ReplyToComment
	---------------------------------------------------------------------------- */
	public GameComment getReplyToComment() {
		return replyToComment;
	}
	public void setReplyToComment(GameComment replyToComment) {
		this.replyToComment = replyToComment;
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
		Get/Set Visibility
	---------------------------------------------------------------------------- */
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	/* ----------------------------------------------------------------------------
		Get/Set Text
	---------------------------------------------------------------------------- */
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	/* ----------------------------------------------------------------------------
		Get/Set Replies
	---------------------------------------------------------------------------- */
	public List<GameComment> getReplies() {
		return replies;
	}
	public void setReplies(List<GameComment> replies) {
		this.replies = replies;
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
		GameComment other = (GameComment) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "GameComment [id=" + id + ", user=" + user + ", game=" + game + "]";
	}
	

}
