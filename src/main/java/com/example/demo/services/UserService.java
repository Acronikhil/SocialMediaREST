package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

//	Create Operation
	public User addUser(User user);

//	Read Operation
	public List<User> getAllUsers();

	public List<User> getUserByName(String name);

//	Update User

//	Delete User

	public void deleteUserById(Integer id);

	public void deleteUserByEmail(String email);
}
