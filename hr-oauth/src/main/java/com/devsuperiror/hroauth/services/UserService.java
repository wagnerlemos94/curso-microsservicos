package com.devsuperiror.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperiror.hroauth.entities.User;
import com.devsuperiror.hroauth.feignclients.UserFeingClient;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeingClient userFeingClient;
	
	public User findByEmail(String email) {
		User user = userFeingClient.findByEmail(email).getBody();
		if(user == null) {
			throw new IllegalArgumentException("Email not fund");
		}else {
			logger.info("Email found: " + email);
			return user;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeingClient.findByEmail(username).getBody();
		if(username == null) {
			throw new UsernameNotFoundException("Email not fund");
		}else {
			logger.info("Email found: " + username);
			return user;
		}
	}

}
