package com.example.demo.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

//import org.apache.logging.log4j.message.Message;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer commentId;

	@NonNull
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_message_id")
	@NonNull
	private Messages message;

	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_commenter_id")
	@NonNull
	@JsonIgnore
	private User commenter;

}
