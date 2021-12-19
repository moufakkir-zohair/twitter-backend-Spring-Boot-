package com.twitter.component.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twitter.component.dao.TweetServiceDao;
import com.twitter.component.entity.Tweet;

@RestController
@RequestMapping("v1/api/tweets/service")
public class TweetServiceController {
        @Autowired
	    private TweetServiceDao tweetServiceDao;
        
	    @PostMapping("/publier")
	    public ResponseEntity<Tweet> publier(@RequestParam String contenu, @RequestParam Long idUser){
	    	Tweet tweet = tweetServiceDao.publier(contenu, idUser);
	    	return new ResponseEntity<>(tweet,HttpStatus.CREATED);
	    }
	    
	    
	    @DeleteMapping("/supprimer/{id}")
	    public ResponseEntity<Void> supprimer(@PathVariable("id") Long tweetId) {
	    	tweetServiceDao.supprimer(tweetId);
	    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    @PutMapping("/aimer/{id}")
	    public ResponseEntity<Tweet> aimer( @PathVariable("id") Long tweetId){
	    	Tweet tweet = tweetServiceDao.aimer(tweetId);
	    	return  new ResponseEntity<Tweet>(tweet , HttpStatus.ACCEPTED);
	    }
	    
}
