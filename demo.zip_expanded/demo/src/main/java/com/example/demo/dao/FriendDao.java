package com.example.demo.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Friend;

@Repository
public class FriendDao {
	
	private List<Friend> friends = null;
	
	private FriendDao() {
		friends = new ArrayList<Friend>();
		Friend f1 = new Friend(1, "OBB", "Bengaluru");
		Friend f2 = new Friend(2, "MLANN", "Chennai");
		Friend f3 = new Friend(3, "BNP", "Chennai");
		Friend f4 = new Friend(4, "OWIOH", "Japan");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
		
	}

	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friends;
		
	}
	
	
	public List<Friend> addNewFriend(Friend f) {
		friends.add(f);
		return friends;
		
	}

	public Friend getFriendById(Integer id) {
		// TODO Auto-generated method stub
		for(int i=0; i<friends.size(); i++) {
			Friend tempFriend  = new Friend();
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				return tempFriend;
			}
		}
		return null;
		
		
	}

	public Friend updateFriendById(Integer id, Friend friend) {
		// TODO Auto-generated method stub
		for(int i=0; i<friends.size(); i++) {
			Friend tempFriend = new Friend();
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friend.setId(id);
				friends.set(i, friend);
				return friends.get(i);
			}
			
		}
		
		return null;
	}

	public List<Friend> deleteFriendById(Integer id) {
		// TODO Auto-generated method stub
		for(int i=0; i< friends.size(); i++) {
			Friend tempFriend = new Friend();
			tempFriend = friends.get(i);
			if(tempFriend.getId() == id) {
				friends.remove(i);
			}
			
		}
		return friends;
	}

}
