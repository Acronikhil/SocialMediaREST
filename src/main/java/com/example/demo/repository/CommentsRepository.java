package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

	public Comments findByCommenterUserId(Integer commenterId);
}
