package com.example.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.FriendEntity;
import com.example.entity.FriendProfileEntity;
import com.example.repository.FriendProfileRepository;
import com.example.repository.FriendRepository;

@RestController
public class WelcomeRestController {

	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private FriendProfileRepository friendProfileRepository;
	
	
	@RequestMapping("/")
	public String welcome() {
		
		FriendEntity fe = new FriendEntity();
		fe.setFirstName("OBB");
		fe.setLastName("OMG");
	
		FriendProfileEntity fpe = new FriendProfileEntity();
		fpe.setLocation("Pata Nai");
		fpe.setYears(8);
		
		fe.setFriendProfileEntity(fpe);
		
		friendProfileRepository.save(fpe);
		friendRepository.save(fe);
		
		
		return "Hello from One to One!!!!Saved!!!!";
	}
	
	
}
