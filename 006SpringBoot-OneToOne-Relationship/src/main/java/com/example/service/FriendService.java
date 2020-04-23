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

	public List<FriendEntity> addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.addFriend(friend);
	}

}
