package com.twitter.component.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.component.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmailAndPassword(String email, String password);
	public List<User> findByFirstNameStartingWith(String keyword);
	public User findByEmail(String email);
}
