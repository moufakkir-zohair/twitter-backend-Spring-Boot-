package com.twitter.component.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.component.entity.Tweet;
import com.twitter.component.entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	public List<Tweet> findByUser(User user);
}
