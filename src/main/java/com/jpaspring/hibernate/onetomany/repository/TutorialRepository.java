package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.Tutorial;

/**
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
public interface TutorialRepository extends JpaRepository<Tutorial, String> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);
}
