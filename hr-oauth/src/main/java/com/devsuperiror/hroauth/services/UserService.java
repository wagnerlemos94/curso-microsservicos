package com.devsuperiror.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperiror.hroauth.entities.User;
import com.devsuperiror.hroauth.feignclients.UserFeingClient;

@Service
public class UserService {
	
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

}
