package com.twitter.component.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="User")
public class User {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String firstName;
	private String lastName;
	
	private String email;
	private String password;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Tweet> tweets = new ArrayList<>();
	
	
	public User() {
		super();
	}
	
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}
	
	
	public void addTweet(Tweet tweet) {
            this.tweets.add(tweet);
            tweet.setUser(this);
    }

    public void removeTweet(Tweet tweet) {
        if (this.tweets.contains(tweet)) {
            this.tweets.remove(tweet);
            tweet.setUser(null);
        }
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
    
    
}
