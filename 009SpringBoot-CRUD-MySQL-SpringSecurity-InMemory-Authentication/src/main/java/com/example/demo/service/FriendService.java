package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;

@Service
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<FriendEntity> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}
	
	
	public List<FriendEntity> addNewFriend(Friend f) {
		return friendDao.addNewFriend(f);
	}


	public FriendEntity getFriendById(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.getFriendById(id);
	}


	public FriendEntity updateFriendById(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendById(id, friend);
	}


	public List<FriendEntity> deleteFriendById(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriendById(id);
	}


	public List<FriendEntity> getFriendByName(String name) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByName(name);
	}


	public List<FriendEntity> getFriendByNameSubString(String name) {
		// TODO Auto-generated method stub
		return friendDao.getFriendByNameSubString(name);
	}

}
