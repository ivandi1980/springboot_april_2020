package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.FriendEntity;
import com.example.entity.FriendProfileEntity;
import com.example.pojo.Friend;
import com.example.repository.FriendProfileRepository;
import com.example.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private FriendProfileRepository friendProfileRepository;

	public List<FriendEntity> addFriend(Friend friend) {
		// TODO Auto-generated method stub
		System.out.println(friend.getFirstName());
		System.out.println(friend.getLastName());
		System.out.println(friend.getProfile().getLocation());
		System.out.println(friend.getProfile().getYears());
		
		FriendProfileEntity fpe = new FriendProfileEntity();
		fpe.setLocation(friend.getProfile().getLocation());
		fpe.setYears(friend.getProfile().getYears());
		
		
		FriendEntity fe = new FriendEntity();
		fe.setFirstName(friend.getFirstName());
		fe.setLastName(friend.getLastName());
		fe.setFriendProfileEntity(fpe);
				
		friendProfileRepository.save(fpe);
		
		friendRepository.save(fe);
		
		return friendRepository.findAll();
		
		
	}

}
