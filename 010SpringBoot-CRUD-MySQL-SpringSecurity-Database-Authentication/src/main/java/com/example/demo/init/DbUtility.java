package com.example.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DbUtility  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteAll();
		
		//create users
		User visitor = new User();
		User manager = new User();
		User admin = new User();
		
		visitor.setUsername("visitor");
		visitor.setPassword(passwordEncoder.encode("visitor123"));
		visitor.setRoles("USER");
		
		manager.setUsername("manager");
		manager.setPassword(passwordEncoder.encode("manager123"));
		manager.setRoles("USER, MANAGER");
		
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin123"));
		admin.setRoles("USER, MANAGER, ADMIN");
		
		//userRepository.save(visitor);
		//userRepository.save(manager);
		//userRepository.save(admin);
		
		List<User> users = Arrays.asList(visitor, manager, admin);
		
		userRepository.saveAll(users);
		
		
		
	}
	
	

}
