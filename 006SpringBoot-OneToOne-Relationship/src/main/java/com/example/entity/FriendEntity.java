package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
	//@JoinColumn(name =  "profile_id")
	@JoinColumns({
		@JoinColumn(name = "profile_id", referencedColumnName = "profile_id"),
		@JoinColumn(name = "years", referencedColumnName ="years")
	})
	private FriendProfileEntity friendProfileEntity;
	
	
	
}
