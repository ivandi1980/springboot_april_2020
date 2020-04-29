package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column (nullable = false)
	private String username;
	@Column (nullable = false)
	private String password;
	private Integer active;
	private String roles = "";
	
	public List<String> getRolesAsList(){
		if(this.roles.length() > 0) {
		  return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<String>();
	}
	
	
}
