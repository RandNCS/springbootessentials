package com.jpaspring.hibernate.onetomany.exception;

/**
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String msg) {
    super(msg);
  }
}