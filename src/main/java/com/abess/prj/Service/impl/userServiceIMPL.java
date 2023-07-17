package com.abess.prj.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abess.prj.Entity.user;
import com.abess.prj.Repository.userRepository;
import com.abess.prj.Service.userService;
@Service 
public class userServiceIMPL implements userService{
	@Autowired
	private final userRepository user_Repository ;
	

	public userServiceIMPL(userRepository user_Repository) {
		
		this.user_Repository = user_Repository;
	}

	@Override
	public user registerUser(String login, String password) {
		if (login==null ||password ==null) {
			return null ;
			
		}else {
			user User =new user();
			User.setlogin(login);
			User.setPassword(password);
		return user_Repository.save(User);
		
		}
	}

	@Override
	public user authentificate(String login, String password) {
		
		return user_Repository.findByLoginAndPassword(login, password);
	}
	

}
