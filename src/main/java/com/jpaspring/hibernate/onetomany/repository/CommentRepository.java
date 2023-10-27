package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {
  List<Comment> findByTutorialId(String postId);
  
  @Transactional
  void deleteByTutorialId(String tutorialId);
}
