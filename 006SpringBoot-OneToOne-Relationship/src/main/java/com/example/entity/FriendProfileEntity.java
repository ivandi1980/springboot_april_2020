package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendProfileEntity implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "profile_id")
	private Integer id;
	private String location;
	private Integer years;

}
