package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome from Spring Boot 2.2.6! Again!!!!";
	}

}
