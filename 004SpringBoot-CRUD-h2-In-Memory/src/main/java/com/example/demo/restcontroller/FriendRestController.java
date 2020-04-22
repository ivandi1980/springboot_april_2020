package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.service.FriendService;

@RestController
public class FriendRestController {
	
	@Autowired
	private FriendService friendService; 
	
	//get all friends
	//@RequestMapping(value = "/friend/all")
	@GetMapping("/friend/all")
	public List<FriendEntity> getAllFriends() {
		return friendService.getAllFriends(); 
		//return "Get list of all friends!";
	}
	
	
	//add new friend
	//@RequestMapping(value = "/friend/add", method = RequestMethod.POST)
	@PostMapping("/friend/add")
	public List<FriendEntity> addNewFriend(@RequestBody Friend friend) {
		System.out.println("Add new friend: " +"with ID: " + friend.getId() +   " Name: " + friend.getName() +  " Location: " + friend.getLocation());
		return friendService.addNewFriend(friend);
	}
	
	//update friend by id
	@PutMapping("/friend/update/{id}")
	public Friend updateFriendById(@PathVariable Integer id, @RequestBody Friend friend) {
		System.out.println("Update friend with id: "  + id + " with new data: Name: " + friend.getName()) ;
		return friendService.updateFriendById(id, friend);
		
	}
	
	
	//delete friend by id
	@DeleteMapping("/friend/delete/{id}")
	public List<Friend> deleteFriendById(@PathVariable Integer id) {
		System.out.println( "Delete friend with id: "  + id ) ;
		return friendService.deleteFriendById(id);
	}
	
	//get friend by id
	@GetMapping("/friend/get/{id}")
	public Friend getFriendById(@PathVariable Integer id) {
		System.out.println( "Get friend with ID: " + id);
		return friendService.getFriendById(id);
	}

}
