package com.twitter.component.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.component.dao.UserTimelineDao;
import com.twitter.component.entity.Tweet;
import com.twitter.component.entity.User;

@RestController
@RequestMapping("v1/api/tweets/userTimeLine")
public class UserTimeLineController {

	@Autowired
	private UserTimelineDao userTimelineDao;
	  
    @PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) throws Exception {
		User userCreated = userTimelineDao.register(user);
		return new ResponseEntity<User>(userCreated , HttpStatus.CREATED);
	}
	
    @GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) throws Exception {
    	User user = userTimelineDao.login(email, password);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
    @GetMapping("/getTweets/{id}")
	public  ResponseEntity<List<Tweet>> getTweets(@PathVariable("id") Long userId){
		List<Tweet> tweets = userTimelineDao.getTweets(userId);
		return new ResponseEntity<List<Tweet>>(tweets,HttpStatus.OK);
	}
    
}

