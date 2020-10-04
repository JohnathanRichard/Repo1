package com.spring.backend.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.entity.User;
import com.spring.backend.repository.UserRepository;
import com.spring.backend.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	//private UserDao userDao;	
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(UsersController.class);
	 
    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
 
        return "Howdy! Check out the Logs to see the output...";
    }
	
	
	@GetMapping("/user/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUser() {
		return userService.findAll();
	}
	
	
	@GetMapping("/user")
	@CrossOrigin(origins = "http://localhost:4200")
	public User getUserById(@RequestParam(name = "id") Integer id) {
		return userService.findById(id);
	}

	
	@PostMapping("/user/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean addUser( @RequestBody User user) {
		
		return userService.addUser(user);
	}

	
	@PutMapping(path = { "/user/{id}" } )
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean editUser( @RequestBody User user, @PathVariable("id") int id) {
		
		return userService.editUser(id,user);
	}

	
	@DeleteMapping(path = { "/user/{id}" } )
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean deleteUser(@PathVariable("id") int id) {
		  
		return userService.deleteUser(id);
	}
	
	@PostMapping("/user/authenticate")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean authenticateUser( @RequestBody User user) {

		return userService.authenticateUser(user);
	}
}
