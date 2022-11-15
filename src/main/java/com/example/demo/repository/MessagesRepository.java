package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {

}
