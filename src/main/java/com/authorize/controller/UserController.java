package com.authorize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorize.exceptions.SignUpFailedException;
import com.authorize.exceptions.UserNotFoundException;
import com.authorize.model.dto.UserDTO;
import com.authorize.model.entity.User;
import com.authorize.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("signUp")
	public ResponseEntity<String> signUpUser(@Valid @RequestBody UserDTO userDto) throws SignUpFailedException {
		User newUser = userService.signUpUser(userDto);
		log.info("user is created successfully");
		String str = "User with userName " + newUser.getName() + " has created successfully";
		return new ResponseEntity<>(str, HttpStatus.CREATED);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserScoreById(@PathVariable int id,@Valid @RequestBody UserDTO userDto) throws UserNotFoundException {
		userDto.setId(id);
		User user = userService.update(userDto);
		log.info("User updation done");
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}

	@GetMapping
	public List<User> getAllUsers() {
		log.info("fetching all users from controller");
		return (List<User>) userService.getUsers();
	}

	@GetMapping("/userName/{userName}")
	public ResponseEntity<User> viewUserByName(@PathVariable String userName) throws UserNotFoundException {
		User user = userService.viewUserByUserName(userName);
		log.info("user of username {} is retrieved",user);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}


}
