package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Messages;
import com.example.demo.entity.User;
import com.example.demo.repository.MessagesRepository;
import com.example.demo.repository.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessagesRepository messageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Messages sendMessage(MessageDTO message) {
		
		User user = userRepository.findByEmail(message.getEmail());
		
		System.out.println("User Found :"+user);
		
		Messages messageToSend = new Messages();
		messageToSend.setSender(user);
		messageToSend.setMessage(message.getMessage());
		
		return messageRepository.save(messageToSend);
	}

	@Override
	public Messages getMessageByUserId(Integer userId) {
		
		return messageRepository.findMessageBySenderUserId(userId);
	}

	@Override
	public List<Messages> getAllMessages() {
		return messageRepository.findAll();
	}
	
	
	
	
	
	

}
