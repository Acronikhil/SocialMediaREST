package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Messages;
import com.example.demo.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping("/addMessage")
	public ResponseEntity<Messages> sendMessage(MessageDTO sendMessage){
		return new ResponseEntity<Messages>(messageService.sendMessage(sendMessage),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/userId/{userId}")
	public ResponseEntity<Messages> getMessageByUserId(@PathVariable Integer userId ) {
		return new ResponseEntity<Messages>(messageService.getMessageByUserId(userId), HttpStatus.FOUND);
	}
	
	@GetMapping("/allMessages")
	public ResponseEntity<List<Messages>> getAllMessages(){
		return new ResponseEntity<List<Messages>>(messageService.getAllMessages(), HttpStatus.FOUND);
	}

}
