package com.spring.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.name = :name and u.password = :password")
	public User getByUsernameAndPassword(
	  @Param("name") String name, 
	  @Param("password") String password);
	

	
}
