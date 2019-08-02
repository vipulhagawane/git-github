package com.dhyanpraveshika.database;

import com.dhyanpraveshika.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

	User getUser(String email, String password);

}
