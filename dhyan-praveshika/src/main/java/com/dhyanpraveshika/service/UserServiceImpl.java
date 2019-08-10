package com.dhyanpraveshika.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhyanpraveshika.database.UserDAO;
import com.dhyanpraveshika.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUsers() {
		
		logger.info("getting users list:{}");
		
		List<User> users = userDAO.findAll();
		logger.info("users list :{}",users);
		
		return users;
	}
	
	

}