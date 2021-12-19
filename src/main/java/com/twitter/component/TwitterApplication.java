package com.twitter.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twitter.component.dao.SearchServiceDao;
import com.twitter.component.dao.TweetServiceDao;
import com.twitter.component.dao.UserTimelineDao;
import com.twitter.component.entity.Tweet;
import com.twitter.component.entity.User;
import com.twitter.component.repository.TweetRepository;
import com.twitter.component.repository.UserRepository;

@SpringBootApplication
public class TwitterApplication implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private TweetServiceDao tweetServiceDao;
//	
//	@Autowired
//	private TweetRepository tweetRepository;
//	
//	@Autowired
//	private UserTimelineDao userTimelineDao;
//	
//	@Autowired
//	private SearchServiceDao searchServiceDao;
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User("Zohair", "MOUFAKKIR","email","123");
//		userDao.register(user1);
//		User user = userRepository.findById(1L).orElse(null);
//		tweetServiceDao.publier(new Tweet("contenu 2", new Date(), user));
//		tweetServiceDao.supprimer(2L);
		
//	    User user2 = userRepository.getById(1L);
//	    
//	    for (Tweet tweet : tweetRepository.findByUser(user2)) {
//			System.out.println(tweet.getContenu());
//		}
		
		
//		tweetServiceDao.supprimer(3L);
//		tweetServiceDao.aimer(4L);
//		
//	    for (Tweet tweet : userTimelineDao.getTweets(1L) ) {
//			System.out.println(tweet.getContenu());
//		}
//		
//	    for (User user : searchServiceDao.chercher("Zo")){
//			System.out.println(user.getEmail());
//		}
//		
		
	}

}
