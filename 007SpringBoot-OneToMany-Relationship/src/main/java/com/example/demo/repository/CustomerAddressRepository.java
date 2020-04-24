package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CustomerAddressEntity;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity, Integer>{

}
