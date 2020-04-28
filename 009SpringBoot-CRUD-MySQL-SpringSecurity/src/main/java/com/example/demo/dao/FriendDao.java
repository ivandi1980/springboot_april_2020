package com.example.demo.dao;



import java.util.List;
import java.util.Optional;

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

	public FriendEntity getFriendById(Integer id) {
		
		 Optional<FriendEntity> optionalFriendEntity =  friendRepository.findById(id);
		 if(optionalFriendEntity.isPresent()) {
			 return optionalFriendEntity.get();
		 }
		 return null;
		
		
	}

	public FriendEntity updateFriendById(Integer id, Friend friend) {
		
		Optional<FriendEntity> optionalFriendEntity = friendRepository.findById(id);
		
		if(optionalFriendEntity.isPresent()) {
			FriendEntity tempFe = optionalFriendEntity.get();
			if(friend.getName() != null) {
				tempFe.setName(friend.getName());
			}
			if(friend.getLocation()!=null) {
				tempFe.setLocation(friend.getLocation());
			}
			friendRepository.saveAndFlush(tempFe);
			return friendRepository.findById(id).get();
		}
		
			
		return null;
	}

	public List<FriendEntity> deleteFriendById(Integer id) {
		
		Optional<FriendEntity> optionalFriendEntity = friendRepository.findById(id);
		if(optionalFriendEntity.isPresent()) {
			friendRepository.deleteById(id);
			return friendRepository.findAll();
		}
		return null;
	}


	public List<FriendEntity> getFriendByName(String name) {
		// TODO Auto-generated method stub
		return friendRepository.findByName(name);
	}


	public List<FriendEntity> getFriendByNameSubString(String name) {
		// TODO Auto-generated method stub
		return friendRepository.findByNameSubString(name);
	}

}
