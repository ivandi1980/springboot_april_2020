package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.pojo.Friend;

@Service
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}
	
	
	public List<Friend> addNewFriend(Friend f) {
		return friendDao.addNewFriend(f);
	}


	public Friend getFriendById(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.getFriendById(id);
	}


	public Friend updateFriendById(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendById(id, friend);
	}


	public List<Friend> deleteFriendById(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriendById(id);
	}

}
