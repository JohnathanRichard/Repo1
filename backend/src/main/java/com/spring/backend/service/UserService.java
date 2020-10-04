package com.spring.backend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.controller.UsersController;
import com.spring.backend.entity.User;
import com.spring.backend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired
	//private UserDao userDao;	
	private UserRepository userRepository;	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		
		Optional<User> u = userRepository.findById(id);
			
		User user = new User();
 
		if (u.isPresent()) { 
			  user =  u.get();
		}
	
		return user;
 	}
		
	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}
	
	public boolean authenticateUser(User user) {
		boolean authentication = false;

		
		
		String name = user.getName();
		String password = user.getPassword();
		//log.info("name " + name );
		
		// get help from DAO if user/password exists
		User userRet = userRepository.getByUsernameAndPassword(name, password);
		//System.out.println("SIZE : " + user.getName());
		 
		if ( (userRet != null) 
				&& userRet.getName().equalsIgnoreCase(name)
				&& userRet.getPassword().equalsIgnoreCase(password) ) {
			  authentication = true;
		} 
		
		//System.out.println(name +" : "+ password);		
		return authentication;
	}

	public boolean deleteUser(int id) {
			userRepository.deleteById(id);
		return true;
	}

	public boolean editUser(Integer id, User user) {
		Optional<User> u = userRepository.findById(id);
		
        boolean retVal = true; 
		if (u.isPresent()) { 
			  user.setId(id);
			  userRepository.save(user);
		}
		else {
			retVal = false;
		}
		
		return retVal;
	}

}
