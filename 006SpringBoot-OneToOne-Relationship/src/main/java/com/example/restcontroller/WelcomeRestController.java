package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.FriendEntity;
import com.example.pojo.Friend;
import com.example.service.FriendService;

@RestController
public class WelcomeRestController {

	@Autowired
	private FriendService friendService;
	
	@RequestMapping("/")
	public String welcome() {
		
		/*
		 * FriendEntity fe = new FriendEntity(); fe.setFirstName("MLANN");
		 * fe.setLastName("AI");
		 * 
		 * FriendProfileEntity fpe = new FriendProfileEntity();
		 * fpe.setLocation("ChenNai"); fpe.setYears(8);
		 * 
		 * fe.setFriendProfileEntity(fpe);
		 * 
		 * friendProfileRepository.save(fpe); friendRepository.saveAndFlush(fe);
		 */
		
		
		return "Hello from One to One!!!!Saved!!!!";
	}
	
	//List<FriendEntity>
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PostMapping("/add")
	public List<FriendEntity> addFriend(@RequestBody Friend friend) {
		return friendService.addFriend(friend);
	}
	
	
}
