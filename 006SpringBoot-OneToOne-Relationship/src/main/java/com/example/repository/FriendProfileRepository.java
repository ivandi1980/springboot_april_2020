package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FriendProfileEntity;

public interface FriendProfileRepository extends JpaRepository<FriendProfileEntity, Integer> {

}
