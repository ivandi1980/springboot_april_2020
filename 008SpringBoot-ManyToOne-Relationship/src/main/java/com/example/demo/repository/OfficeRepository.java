package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OfficeEntity;

public interface OfficeRepository extends JpaRepository<OfficeEntity, Integer> {

}
