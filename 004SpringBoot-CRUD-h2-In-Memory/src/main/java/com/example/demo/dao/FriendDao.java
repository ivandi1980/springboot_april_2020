package com.example.demo.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;

import javassist.expr.NewArray;

@Repository
public class FriendDao {
	

	@Autowired
	private FriendRepository friendRepository;


	public List<FriendEntity> getAllFriends() {

		return friendRepository.findAll();
		
		
	}
	
	
	public List<FriendEntity> addNewFriend(Friend f) {
		
		FriendEntity fe = new FriendEntity();
		
		fe.setName(f.getName());
		fe.setLocation(f.getLocation());
		
		friendRepository.save(fe);
		
		return friendRepository.findAll();
		
	}

	public Friend getFriendById(Integer id) {
		
		return null;
		
		
	}

	public Friend updateFriendById(Integer id, Friend friend) {
			
		return null;
	}

	public List<Friend> deleteFriendById(Integer id) {
		
		return null;
	}

}
