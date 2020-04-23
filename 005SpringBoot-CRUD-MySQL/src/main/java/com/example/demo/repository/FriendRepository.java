package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer>{

	//no method signatures required!
	//all default CRUD methods are pre-implemented
	
	 List<FriendEntity> findByName(String name);
	 
	 List<FriendEntity> findByLocation(String location);
	
	 @Query("from FriendEntity fe where fe.name like %?1%")
	 List<FriendEntity> findByNameSubString(String name);
	
}
