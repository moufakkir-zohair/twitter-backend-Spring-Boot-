package com.twitter.component.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twitter.component.entity.Tweet;
import com.twitter.component.entity.User;
import com.twitter.component.repository.TweetRepository;
import com.twitter.component.repository.UserRepository;

@Service
public class TweetServiceDao {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    public Tweet publier(String contenu, Long idUser) {
    	User user = userRepository.findById(idUser).orElse(null);
    	Tweet tweet = new Tweet(contenu, new Date(), user);
    	return tweetRepository.save(tweet);
    }
    
    public void supprimer(Long tweetId) {
    	tweetRepository.deleteById(tweetId);
    }
    
    public Tweet aimer(Long tweetId){
    	Tweet tweet = tweetRepository.findById(tweetId).orElse(null);
    	tweet.setFavorable(!tweet.getFavorable());
    	return tweetRepository.save(tweet);
    }

}
