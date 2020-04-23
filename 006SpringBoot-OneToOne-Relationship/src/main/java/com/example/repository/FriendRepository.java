package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Integer>{

}
