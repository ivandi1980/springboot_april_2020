package com.example.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.FriendEntity;
import com.example.entity.FriendProfileEntity;
import com.example.pojo.Friend;
import com.example.pojo.FriendProfile;
import com.example.repository.FriendProfileRepository;
import com.example.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {
	
	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private FriendProfileRepository friendProfileRepository;

	public List<Friend> addFriend(Friend friend) {
		// TODO Auto-generated method stub
		System.out.println(friend.getFirstName());
		System.out.println(friend.getLastName());
		System.out.println(friend.getProfile().getLocation());
		System.out.println(friend.getProfile().getYears());
		
		FriendProfileEntity fpe = new FriendProfileEntity();
		fpe.setLocation(friend.getProfile().getLocation());
		fpe.setYears(friend.getProfile().getYears());
		
		
		FriendEntity fee = new FriendEntity();
		fee.setFirstName(friend.getFirstName());
		fee.setLastName(friend.getLastName());
		fee.setFriendProfileEntity(fpe);
				
		friendProfileRepository.save(fpe);
		
		friendRepository.save(fee);
		
		//List<FriendEntity> fel = friendRepository.findAll();
		
		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<Friend>();
		
		for (FriendEntity fe: friendEntityList) {
			Friend tempFriend = new Friend();
			FriendProfile tempFriendProfile = new FriendProfile();
			tempFriend.setFirstName(fe.getFirstName());
			tempFriend.setLastName(fe.getLastName());
			tempFriend.setFriendId(fe.getFriendId());
			tempFriendProfile.setLocation(fe.getFriendProfileEntity().getLocation());
			tempFriendProfile.setYears(fe.getFriendProfileEntity().getYears());
			tempFriendProfile.setId(fe.getFriendProfileEntity().getId());
			
			tempFriend.setProfile(tempFriendProfile);
			
			friendList.add(tempFriend);
			
		}
		
		
		
		
		return friendList;
		
		
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		List<FriendEntity> friendEntityList = friendRepository.findAll();
		List<Friend> friendList = new ArrayList<Friend>();
		
		for (FriendEntity fe: friendEntityList) {
			Friend tempFriend = new Friend();
			FriendProfile tempFriendProfile = new FriendProfile();
			System.out.println(fe.getFirstName() + " " +  fe.getFriendId() + " " + fe.getFriendProfileEntity().getId() + " " +fe.getFriendProfileEntity().getLocation());
			tempFriend.setFirstName(fe.getFirstName());
			tempFriend.setLastName(fe.getLastName());
			tempFriend.setFriendId(fe.getFriendId());
			tempFriendProfile.setLocation(fe.getFriendProfileEntity().getLocation());
			tempFriendProfile.setYears(fe.getFriendProfileEntity().getYears());
			tempFriendProfile.setId(fe.getFriendProfileEntity().getId());
			
			tempFriend.setProfile(tempFriendProfile);
			
			friendList.add(tempFriend);
			
		}
		
		
		
		
		return friendList;
	}


	public Friend updateFriend(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> optionalFriendEntity =   friendRepository.findById(id);
		
		if(optionalFriendEntity.isPresent()) {
			FriendEntity tempFriendEntity = new FriendEntity();
			FriendProfileEntity tempFriendProfileEntity = new FriendProfileEntity();
			
			//tempFriendProfileEntity.setId(optionalFriendEntity.get().getFriendProfileEntity().getId());
			tempFriendProfileEntity.setLocation(friend.getProfile().getLocation());
			tempFriendProfileEntity.setYears(friend.getProfile().getYears());
			
			tempFriendEntity.setFriendId(id);
			//tempFriendEntity.setFriendId(optionalFriendEntity.get().getFriendId());
			tempFriendEntity.setFirstName(friend.getFirstName());
			tempFriendEntity.setLastName(friend.getLastName());
			
			tempFriendEntity.setFriendProfileEntity(tempFriendProfileEntity);
			
			friendProfileRepository.saveAndFlush(tempFriendProfileEntity);
			friendRepository.saveAndFlush(tempFriendEntity);
			
			FriendEntity returnFriendEntity  = friendRepository.findById(id).get();
			
			Friend returnF = new Friend();
			FriendProfile returnFP = new FriendProfile();
			returnFP.setId(returnFriendEntity.getFriendProfileEntity().getId());
			returnFP.setLocation(returnFriendEntity.getFriendProfileEntity().getLocation());
			returnFP.setYears(returnFriendEntity.getFriendProfileEntity().getYears());
			
			returnF.setFriendId(returnFriendEntity.getFriendId());
			returnF.setFirstName(returnFriendEntity.getFirstName());
			returnF.setLastName(returnFriendEntity.getLastName());
			returnF.setProfile(returnFP);
			
			return returnF;
		
		}
		
		return new Friend();
	}

	public Friend updateFriendPatch(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> optionalFriendEntity =   friendRepository.findById(id);
		
		if(optionalFriendEntity.isPresent()) {
			FriendEntity tempFriendEntity = new FriendEntity();
			FriendProfileEntity tempFriendProfileEntity = new FriendProfileEntity();
			
			//tempFriendProfileEntity.setId(optionalFriendEntity.get().getFriendProfileEntity().getId());
			
			
			friendProfileRepository.saveAndFlush(tempFriendProfileEntity);
			friendRepository.saveAndFlush(tempFriendEntity);
			
			FriendEntity returnFriendEntity  = friendRepository.findById(id).get();
			Friend returnF = new Friend();
			FriendProfile returnFP = new FriendProfile();
			returnFP.setId(returnFriendEntity.getFriendProfileEntity().getId());
			returnFP.setLocation(returnFriendEntity.getFriendProfileEntity().getLocation());
			returnFP.setYears(returnFriendEntity.getFriendProfileEntity().getYears());
			
			returnF.setFriendId(returnFriendEntity.getFriendId());
			returnF.setFirstName(returnFriendEntity.getFirstName());
			returnF.setLastName(returnFriendEntity.getLastName());
			returnF.setProfile(returnFP);
			
			return returnF;
		
		}
		
		return new Friend();
		
	
	}

	public Friend deleteFriend(Integer id) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> fe= friendRepository.findById(id);
		if(fe.isPresent()) {
			friendRepository.deleteById(id);
			friendProfileRepository.deleteById(fe.get().getFriendProfileEntity().getId());
			//friendRepository.deleteById(id);
			
			return new Friend(0, null, null, null);
		}
		
		return new Friend();
	}

}
