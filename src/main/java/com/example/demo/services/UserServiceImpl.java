package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
	 	List<User>	u = userRepository.findAll();
		return u;
	}

	@Override
	public List<User> getUserByName(String name) {

		System.out.println(userRepository.findByName(name));
		return userRepository.findByName(name);
	}

	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public void deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		userRepository.deleteByEmail(email);
	}

}
