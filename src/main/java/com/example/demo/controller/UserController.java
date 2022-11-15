package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

//	@RequestMapping("/")
//	public String greet() {
//		return "Hello User";
//	}

	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/findByName")
	public ResponseEntity<List<User>> findUserByName(@RequestBody String name) {
		System.out.println("Name called to search:"+ name);
		return new ResponseEntity<List<User>>(userService.getUserByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>( userService.addUser(user),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/addUser/{uid}")
	public ResponseEntity deleteUser(@PathVariable Integer userId){
		 userService.deleteUserById(userId);
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
