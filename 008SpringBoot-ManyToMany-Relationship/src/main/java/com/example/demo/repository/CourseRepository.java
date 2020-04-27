package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}
