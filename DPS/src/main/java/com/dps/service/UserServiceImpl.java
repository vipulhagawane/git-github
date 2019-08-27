package com.dps.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dps.exception.UserAlreadyExistException;
import com.dps.model.BlogDetails;
import com.dps.model.UserDetails;
import com.dps.model.VideoDetails;
import com.dps.repository.UserDetailsRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDetailsRepo userdetailsrepo;
	
	@Override
	public void createUser(UserDetails userdetails) {
		if (emailExists(userdetails.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userdetails.getEmail());
        }
		userdetailsrepo.save(userdetails);
	}
	private boolean emailExists(final String email) {
        return userdetailsrepo.findByEmail(email) != null;
    }
	@Override
	public UserDetails findUserByEmail(String email) {
		return userdetailsrepo.findByEmail(email);
	}

	@Override
	public String getUserPassword(String email) {
		return userdetailsrepo.findPwdByEmail(email);
	}

	@Override
	public void changeUserPassword(final UserDetails user, final String password) {
//		user.setPassword(passwordEncoder.encode(password));
		user.setPassword(password);
		userdetailsrepo.save(user);
		
	}

	@Override
	public boolean checkIfValidOldPassword(final UserDetails user, final String oldPassword) {
		
		return oldPassword.equalsIgnoreCase(user.getPassword());
		
//		return passwordEncoder.matches(oldPassword, user.getPassword());
	}
	@Override
	public UserDetails findByEmailIdIgnoreCase(String emailId) {
		
		return userdetailsrepo.findByEmail(emailId);
	}
	@Override
	public char[] geek_Password(int len) {
		
		System.out.println("Generating password using random() : "); 
        System.out.print("Your new password is : "); 
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
                String symbols = "!@#$%^&*_=+-/.?<>)"; 
		String values = Capital_chars + Small_chars + 
        numbers + symbols; 
		// Using random method 
        Random rndm_method = new Random(); 
		char[] password = new char[len]; 
		for (int i = 0; i < len; i++) 
        { 
            password[i] = 
              values.charAt(rndm_method.nextInt(values.length())); 
		} 
        return password; 
	}
	
	
}
