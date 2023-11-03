
package com.jpaspring.hibernate.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.User;


/**
 * Author: Randjith Created on @ 3 Nov 2023
 */

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
