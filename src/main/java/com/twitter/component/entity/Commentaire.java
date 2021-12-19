package com.twitter.component.entity;

import javax.persistence.*;

@Entity(name="Commentaire")
public class Commentaire {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id",foreignKey = @ForeignKey(name="user_id_fk"))
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tweetId", referencedColumnName = "id",foreignKey = @ForeignKey(name="tweet_id_fk"))
	private Tweet tweet;
	
	private String commentaire;
	
	public Commentaire(String commentaire) {
		super();
		this.commentaire = commentaire;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Tweet getTweet() {
		return tweet;
	}
	
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Long getId() {
		return id;
	}
	
}
