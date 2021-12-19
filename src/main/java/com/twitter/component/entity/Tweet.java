package com.twitter.component.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity(name="Tweet")

public class Tweet {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contenu;
	private Date datPub;
	private Boolean favorable = false;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
    @JoinColumn(
    		name="user_id",
    		nullable = false,
    		referencedColumnName = "id" ,
    		foreignKey = @ForeignKey(name="user_tweet_fk")
    		)
	private User user;
	
	@OneToMany(
            mappedBy = "tweet",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
	private List<Commentaire> commentaires = new ArrayList<>();
	
	public Tweet() {
		super();
	}
	
	public Tweet(String contenu, Date datPub,User user) {
		super();
		this.contenu = contenu;
		this.datPub = datPub;
		this.user = user;
	}

	public String getContenu() {
		return contenu;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public Date getDatPub() {
		return datPub;
	}
	
	public void setDatPub(Date datPub) {
		this.datPub = datPub;
	}
	
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getFavorable() {
		return favorable;
	}

	public void setFavorable(Boolean favorable) {
		this.favorable = favorable;
	}
		
}
