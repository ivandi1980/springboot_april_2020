package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeEntity {

	@Id
	@Column(name = "office_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String city;
	
}
