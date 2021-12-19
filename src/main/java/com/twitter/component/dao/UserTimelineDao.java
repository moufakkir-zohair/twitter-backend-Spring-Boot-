package com.twitter.component.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.component.entity.Tweet;
import com.twitter.component.entity.User;
import com.twitter.component.exceptions.UserAlreadyExistsException;
import com.twitter.component.exceptions.UserNotExistsException;
import com.twitter.component.repository.TweetRepository;
import com.twitter.component.repository.UserRepository;


@Service
public class UserTimelineDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TweetRepository tweetRepository;
	
	public User register(User user) throws Exception{
		User userdb = userRepository.findByEmail(user.getEmail());
		if(userdb != null) throw new UserAlreadyExistsException("User with this email already exists");
		return userRepository.save(user);
	}
	
	public User login(String email, String password) throws Exception {
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user==null) throw new UserNotExistsException("User doesn't exist");
		return user;
	}
	
	public List<Tweet> getTweets(Long userId){
		User user = userRepository.getById(1L);
		return tweetRepository.findByUser(user);
	}
	
}
