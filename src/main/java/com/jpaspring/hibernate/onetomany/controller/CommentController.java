package com.jpaspring.hibernate.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaspring.hibernate.onetomany.exception.ResourceNotFoundException;
import com.jpaspring.hibernate.onetomany.model.Comment;
import com.jpaspring.hibernate.onetomany.repository.CommentRepository;
import com.jpaspring.hibernate.onetomany.repository.TutorialRepository;

/**
 * 
 * Author: Randjith
 * Created on: 22 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/")
public class CommentController {

  @Autowired
  private TutorialRepository tutorialRepository;

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping(path="tutorials/{tutorialId}/comments", produces={"application/json"})
  public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value="tutorialId") String tutorialId) {
    if (!tutorialRepository.existsById(tutorialId)) {
      throw new ResourceNotFoundException("Not found Tutorial with id=" + tutorialId);
    }

    List<Comment> comments=commentRepository.findByTutorialId(tutorialId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
  }

  @GetMapping(path="comments/{id}", produces={"application/json"})
  public ResponseEntity<Comment> getCommentsByTutorialId(@PathVariable(value="id") String id) {
    Comment comment=commentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id=" + id));

    return new ResponseEntity<>(comment, HttpStatus.OK);
  }

  @PostMapping(path="tutorials/{tutorialId}/comments", consumes={"application/json"}, produces={"application/json"})
  public ResponseEntity<Comment> createComment(@PathVariable(value="tutorialId") String tutorialId,
      @RequestBody Comment commentRequest) {
    Comment comment=tutorialRepository.findById(tutorialId).map(tutorial -> {
      commentRequest.setTutorial(tutorial);
      return commentRepository.save(commentRequest);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id=" + tutorialId));

    return new ResponseEntity<>(comment, HttpStatus.CREATED);
  }

  @PutMapping(path="comments/{id}", consumes={"application/json"} , produces={"application/json"})
  public ResponseEntity<Comment> updateComment(@PathVariable("id") String id, @RequestBody Comment commentRequest) {
    Comment comment=commentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

    comment.setContent(commentRequest.getContent());

    return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
  }

  @DeleteMapping(path="comments/{id}", consumes={"application/json"} , produces={"application/json"})
  public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") String id) {
    commentRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  @DeleteMapping(path="tutorials/{tutorialId}/comments", consumes={"application/json"} , produces={"application/json"})
  public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(@PathVariable(value="tutorialId") String tutorialId) {
    if (!tutorialRepository.existsById(tutorialId)) {
      throw new ResourceNotFoundException("Not found Tutorial with id=" + tutorialId);
    }

    commentRepository.deleteByTutorialId(tutorialId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
