package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.entity.Comments;
import com.example.demo.entity.User;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.MessagesRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsRepository commentsRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessagesRepository messageRepository;

	@Override
	public Comments addComment(CommentsDTO comment) {
		Comments addComment = new Comments();
		User sender = userRepository.findByUserId(comment.getCommenterId());
//		User commenter = userRepository.findByUserId(comment.getMessageId());
		
		System.out.println("Sender of this comment:"+ sender);

		addComment.setComment(comment.getComment());
		addComment.setCommenter(sender);
		addComment.setMessage(messageRepository.findMessageByMessageId(comment.getMessageId()));


		return commentsRepository.save(addComment);
	}

	@Override
	public Comments getCommentByCommentId(Integer commentId) {
		
		return commentsRepository.findByCommenterUserId(commentId);
	}

	@Override
	public List<Comments> getAllComments() {
		
		return commentsRepository.findAll();
	}

	@Override
	public void deleteCommentByCommentId(Integer commentId) {
		commentsRepository.deleteById(commentId);
		
	}

}
