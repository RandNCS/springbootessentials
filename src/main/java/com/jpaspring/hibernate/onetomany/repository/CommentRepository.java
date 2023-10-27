package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.Comment;

/**
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
public interface CommentRepository extends JpaRepository<Comment, String> {
  List<Comment> findByTutorialId(String postId);
  
  @Transactional
  void deleteByTutorialId(String tutorialId);
}
