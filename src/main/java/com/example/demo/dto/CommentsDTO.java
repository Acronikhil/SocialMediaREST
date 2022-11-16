package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentsDTO {

	
	private String comment;

	
	private Integer messageId;

	
	private Integer commenterId;
}
