package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCourseRestController {
	
	
	
	@PostMapping("/")
	public String addEmployeeOffice() {

		return "Many To Many!!!!";
	}

}
