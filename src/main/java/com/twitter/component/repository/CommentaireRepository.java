package com.twitter.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.component.entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
