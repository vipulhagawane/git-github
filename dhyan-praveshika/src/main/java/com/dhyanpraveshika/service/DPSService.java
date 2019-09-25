package com.dhyanpraveshika.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhyanpraveshika.database.UserDAO;
import com.dhyanpraveshika.dto.VideosDTO;
import com.dhyanpraveshika.entity.User;

@Service
@Transactional
public class DPSService{
	
	@Autowired
	private UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(DPSService.class);
	
	
	public User checkUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
	
		
		if(!email.trim().equalsIgnoreCase("")  && !password.trim().equalsIgnoreCase("")) {
			logger.info("user details:{}",email +"\t" +password);
		User user = userDAO.getUser(email,password);
		
		
		if(user != null && user.getReg_type()!=null && user.getReg_type().equalsIgnoreCase("admin"))
		{
			logger.info("user role admin:{}",user.getReg_type());
			return user;
		}
		else {
			logger.info("user role not admin:{}");
			return null;
		}
		}
		else {
			logger.info("Email or Password Empty:{}");
			return null;
		}
	}
	
	
	public boolean addvideoUrl(HttpServletRequest request)
	{
		return false;
		
	}


	public VideosDTO getVideo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
