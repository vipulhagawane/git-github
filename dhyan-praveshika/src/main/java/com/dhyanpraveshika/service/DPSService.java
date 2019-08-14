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
	
	
	public boolean checkUser(HttpServletRequest request) {
		boolean checkUser = false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		logger.info("user details:{}",email +"\t" +password);
		
		User user = userDAO.getUser(email,password);
		if(user != null)
		{
			checkUser = true;
		}
		
		return checkUser;
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
