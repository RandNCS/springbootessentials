package com.jpaspring.hibernate.onetomany.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GenericGenerator(name = "comment_generator", strategy = "com.jpaspring.hibernate.onetomany.generators.CommentIdGenerator")
  @GeneratedValue(generator = "comment_generator")
  private String id;

  @Lob
  private String content;

//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tutorial_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Tutorial tutorial;

  public String getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Tutorial getTutorial() {
    return tutorial;
  }

  public void setTutorial(Tutorial tutorial) {
    this.tutorial = tutorial;
  }

}
