package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.OfficeEntity;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OfficeRepository;

@RestController
public class EmployeeOfficeRestController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	
	@PostMapping("/add")
	public List<EmployeeEntity> addEmployeeOffice(@RequestBody EmployeeEntity ee) {

		EmployeeEntity ee1 = new EmployeeEntity();
		ee1.setEmployeeName(ee.getEmployeeName());
		
		OfficeEntity oe = new OfficeEntity();
		oe.setCity(ee.getOfficeEntity().getCity());
		
		officeRepository.save(oe);
		
		ee1.setOfficeEntity(oe);
		employeeRepository.save(ee1);
		
		return employeeRepository.findAll();
	}

}
