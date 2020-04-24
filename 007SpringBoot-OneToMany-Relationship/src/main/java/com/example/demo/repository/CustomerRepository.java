package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerEnity;

public interface CustomerRepository extends JpaRepository<CustomerEnity	,	Integer> {

}
