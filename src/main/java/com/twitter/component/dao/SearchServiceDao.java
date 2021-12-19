package com.twitter.component.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.component.entity.User;
import com.twitter.component.repository.UserRepository;

@Service
public class SearchServiceDao {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> chercher(String keyWord){
		return userRepository.findByFirstNameStartingWith(keyWord);
	}
}
