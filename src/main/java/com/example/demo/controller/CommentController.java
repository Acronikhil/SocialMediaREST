package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentsDTO;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Messages;
import com.example.demo.services.CommentsService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentsService commentService;
	
	@PostMapping("/addComment")
	public ResponseEntity<Comments> sendComment(CommentsDTO sendComment){
		return new ResponseEntity<Comments>(commentService.addComment(sendComment),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/commentId/{commentId}")
	public ResponseEntity<Comments> getCommentByCommentId(@PathVariable Integer commentId ) {
		return new ResponseEntity<Comments>(commentService.getCommentByCommentId(commentId), HttpStatus.FOUND);
	}
	
	@GetMapping("/allComments")
	public ResponseEntity<List<Comments>> getAllComments(){
		return new ResponseEntity<List<Comments>>(commentService.getAllComments(), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteById/{commentId}")
	public ResponseEntity<String> deleteCommentById(@PathVariable Integer commentId){
		commentService.deleteCommentByCommentId(commentId);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}

}
