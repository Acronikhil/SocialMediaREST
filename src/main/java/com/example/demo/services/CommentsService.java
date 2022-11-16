package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.entity.Comments;

public interface CommentsService {
	
	public Comments addComment(CommentsDTO comment);
	
	public Comments getCommentByCommentId(Integer commentId);
	public List<Comments> getAllComments();
	
	public void deleteCommentByCommentId(Integer commentId);

}
