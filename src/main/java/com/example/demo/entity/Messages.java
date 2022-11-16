package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Integer messageId;

	@NonNull
	private String message;

	@ManyToOne
	@JoinColumn(name = "fk_sender_id")
	@NonNull
	@JsonIgnoreProperties({"userId","userName","phone"})
	private User sender;
	
//	@OneToMany(mappedBy="message",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Comments> allComments;

}
