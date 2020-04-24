package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FriendDao;
import com.example.entity.FriendEntity;
import com.example.pojo.Friend;

@Service("friendService")
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<Friend> addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.addFriend(friend);
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public Friend updateFriend(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriend(id, friend);
	}

	public Friend updateFriendPatch(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriendPatch(id, friend);
	}

	public Friend deleteFriend(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.deleteFriend(id);
	}

}
