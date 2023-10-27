package com.jpaspring.hibernate.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootOneToManyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootOneToManyApplication.class, args);
  }
}
