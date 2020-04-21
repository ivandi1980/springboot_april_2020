package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsRestController {
	
	List<Friends> friends = new ArrayList<Friends>();
	
	public FriendsRestController() {
	
		Friends f1 = new Friends(1, "OBBO", "Chennai");
		Friends f2 = new Friends(2, "MLANN", "Chennai");
		Friends f3 = new Friends(3, "BNP", "Chennai");
		Friends f4 = new Friends(4, "OWIOH", "Japan");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
			
	}
	
	
	@RequestMapping("/")
	public String welcome() {
		return "Friends Community Ver 1.0!!!!";
	}
	
	@RequestMapping("/all")
	public List<Friends> getFriends() {
		return friends;
	}

	@RequestMapping("/get/check")
	public String checkmethod() {
		return "Check Ok!!!";
	}
	
}
