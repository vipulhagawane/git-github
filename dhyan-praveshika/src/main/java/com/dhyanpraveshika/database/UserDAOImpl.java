package com.dhyanpraveshika.database;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.entity.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

	@Override
	public User getUser(String email, String password) {
		String hql = "from User u where u.email =: email and u.password =: password";
		Query query = entityManager.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> users = query.getResultList();
		
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

	
	
	/*
	 * @Override public List<String> getTokens() { String hql =
	 * "select fcm_token from User"; Query query = entityManager.createQuery(hql);
	 * return query.getResultList(); }
	 */

	@Override
	public List<String> getTokens() {
		String hql = "select distinct(fcm_token) from User"; 
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}
}
