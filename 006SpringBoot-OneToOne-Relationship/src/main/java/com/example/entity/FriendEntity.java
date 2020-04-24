package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table (uniqueConstraints = {@UniqueConstraint(columnNames = {"firstName"})})
public class FriendEntity implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer friendId;
	@Column
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
