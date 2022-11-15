package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	@NonNull
	private String userName;

	@Column(name = "email")
	@NonNull
	private String email;

	@Column(name = "phone")
	@NonNull
	private Long phone;

	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Messages> messages;

	@OneToOne(mappedBy = "commenter", cascade = CascadeType.ALL)
	@JsonIgnore
	private Comments commenter;

	
	
	

}
