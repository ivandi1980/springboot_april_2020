package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FriendEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer friendId;
	private String firstName;
	private String lastName;
	
	@OneToOne
	@JoinColumn(name =  "profile_id")
	private FriendProfileEntity friendProfileEntity;
	
	
	
}
