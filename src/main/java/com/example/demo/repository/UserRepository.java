package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	public List<User> findByUserName(String name);
	
	@Query("from User u where u.userId=:userId")
	public User findByUserId(Integer userId);
	
	public User findByEmail(String email);
	
	public void deleteByUserName(String userName);
	
	public void deleteByEmail(String email);
	
}
