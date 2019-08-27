package com.dps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dps.model.UserDetails;


@Repository
public interface UserDetailsRepo extends CrudRepository<UserDetails, Long> {


	UserDetails findByEmail(String email);
	
	UserDetails findUserByEmail(String email);
	
	String findPwdByEmail(String email);

}
