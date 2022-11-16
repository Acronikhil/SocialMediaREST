package com.example.demo.dto;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public class MessageDTO {

	
	@NonNull
	private String message;

	@NonNull
	private String email;
}
