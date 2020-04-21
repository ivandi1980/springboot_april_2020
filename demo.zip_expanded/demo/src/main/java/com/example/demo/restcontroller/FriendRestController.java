package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Friend;

@RestController
public class FriendRestController {
	
	//get all friends
	//@RequestMapping(value = "/friend/all")
	@GetMapping("/friend/add")
	public String getAllFriends() {
		return "Get list of all friends!";
	}
	
	
	//add new friend
	//@RequestMapping(value = "/friend/add", method = RequestMethod.POST)
	@PostMapping("/friend/add")
	public String addNewFriend(@RequestBody Friend friend) {
		return "Add new friend: " +"with ID: " + friend.getId() +   " Name: " + friend.getName() +  " Location: " + friend.getLocation();
	}
	
	//update friend by id
	@PutMapping("/friend/update/{id}")
	public String updateFriendById(@PathVariable Integer id, @RequestBody Friend friend) {
		return "Update friend with id: "  + id + " with new data: Name: " + friend.getName() ;
	}
	
	
	//delete friend by id
	@DeleteMapping("/friend/delete/{id}")
	public String deleteFriendById(@PathVariable Integer id) {
		return "Delete friend with id: "  + id  ;
	}
	
	//get friend by id
	@GetMapping("/friend/get/{id}")
	public String getFriendById(@PathVariable Integer id) {
		return "Get friend with ID: " + id;
	}

}
