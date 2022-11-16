package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Messages;

public interface MessageService {
	
	public Messages sendMessage(MessageDTO message);
	
	public Messages getMessageByUserId(Integer userId);
	
	public List<Messages> getAllMessages();

}
