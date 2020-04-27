package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String studentName;
	
	@ManyToMany
	@JoinTable(name = "student_course_mappping",
				joinColumns = @JoinColumn(name= "student_id"), 
				inverseJoinColumns =  @JoinColumn(name ="course_id"))
	private Collection<CourseEntity> courseEntities = new ArrayList<CourseEntity>();
	

}
