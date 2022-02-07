package com.skilldistillery.mygamelist.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilldistillery.mygamelist.CompositeId;
import com.skilldistillery.mygamelist.SpringUpdate;
import com.skilldistillery.mygamelist.compositeids.GameRelationId;

@Entity
@IdClass(GameRelationId.class)
@Table(name="game_relation")
public class GameRelation implements CompositeId<GameRelationId> {
	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name="primary_game_id")
	private Game primaryGame;
	
	@Id
	@ManyToOne
	@JoinColumn(name="other_game_id")
	private Game otherGame;
	
	@SpringUpdate
	@ManyToOne
	@JoinColumn(name="relationship_id")
	private Relationship relationship;
	
	/* ----------------------------------------------------------------------------
		Constructors
	---------------------------------------------------------------------------- */
	public GameRelation() {}
	

	/* ----------------------------------------------------------------------------
		Get GameRelationId
	---------------------------------------------------------------------------- */
	@Override
	public GameRelationId getId() {
		return new GameRelationId(primaryGame,otherGame);
	}
	
	/* ----------------------------------------------------------------------------
		Get/Set Primary Game
	---------------------------------------------------------------------------- */
	public Game getPrimaryGame() {
		return primaryGame;
	}
	public void setPrimaryGame(Game primaryGame) {
		this.primaryGame = primaryGame;
	}
	
	
	/* ----------------------------------------------------------------------------
		Get/Set Other Game
	---------------------------------------------------------------------------- */
	public Game getOtherGame() {
		return otherGame;
	}
	public void setOtherGame(Game otherGame) {
		this.otherGame = otherGame;
	}

	
	/* ----------------------------------------------------------------------------
		Get/Set Relationship
	---------------------------------------------------------------------------- */
	public Relationship getRelationship() {
		return relationship;
	}
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	
	/* ----------------------------------------------------------------------------
		Misc
	---------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "GameRelation [primaryGame=" + primaryGame + ", otherGame=" + otherGame + ", relationship="
				+ relationship + "]";
	}
	
	
}
