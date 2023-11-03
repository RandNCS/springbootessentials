package com.jpaspring.hibernate.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 
 * Author: Randjith
 * Created on: 22 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@SpringBootApplication(/* exclude = { SecurityAutoConfiguration.class } */)
public class SpringBootOneToManyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootOneToManyApplication.class, args);
  }
}
