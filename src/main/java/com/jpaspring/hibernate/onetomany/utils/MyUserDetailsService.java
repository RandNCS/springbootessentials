
package com.jpaspring.hibernate.onetomany.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpaspring.hibernate.onetomany.model.User;
import com.jpaspring.hibernate.onetomany.repository.UserRepository;

/**
 * Author: Randjith Created on @ 3 Nov 2023
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User 404");
		}
		return new UserPrincipal(user);
	}

}
