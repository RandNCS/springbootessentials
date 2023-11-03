package com.jpaspring.hibernate.onetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Author: Randjith
 * Created on: 23 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
	@GenericGenerator(name = "tutorial_generator", strategy = "com.jpaspring.hibernate.onetomany.generators.TutorialIdGenerator")
	@GeneratedValue(generator = "tutorial_generator")
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	public Tutorial() {

	}

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}

}
