package com.twitter.component.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.component.dao.SearchServiceDao;
import com.twitter.component.entity.User;

@RestController
@RequestMapping("v1/api/tweets/search")

public class SearchServiceController {
	
	@Autowired
	private SearchServiceDao searchServiceDao;
		
    @GetMapping("/chercher")	
	public ResponseEntity<List<User>> chercher(@RequestParam String keyWord){
		List<User> users = searchServiceDao.chercher(keyWord);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
}
