package com.dps.service;

import java.util.List;

import com.dps.model.BlogDetails;
import com.dps.model.UserDetails;
import com.dps.model.VideoDetails;


public interface UserService {
	
	UserDetails findUserByEmail(String email);
	
	UserDetails findByEmailIdIgnoreCase(String emailId);
	
	public void createUser(UserDetails userdetails);
	
	public String getUserPassword(String email);
	
	void changeUserPassword(UserDetails user, String password);
	
	boolean checkIfValidOldPassword(UserDetails user, String password);
	
	char[] geek_Password(int len);
	
	
	
	
}
