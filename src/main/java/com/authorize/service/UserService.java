package com.authorize.service;

import com.authorize.exceptions.SignUpFailedException;
import com.authorize.exceptions.UserNotFoundException;
import com.authorize.model.dto.UserDTO;
import com.authorize.model.entity.User;

public interface UserService {
	
	User signUpUser(UserDTO user) throws SignUpFailedException;
	User update(UserDTO updateUser) throws UserNotFoundException;
	Iterable<User> getUsers();
	User viewUserByUserName(String userName) throws UserNotFoundException;
}
