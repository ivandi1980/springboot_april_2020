package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerAddressEntity;
import com.example.demo.entity.CustomerEnity;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.CustomerAddress;
import com.example.demo.repository.CustomerAddressRepository;
import com.example.demo.repository.CustomerRepository;


@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAddressRepository customAddressRepository;
	
	@RequestMapping("/")
	public List<Customer> welcome() {
		
		List<CustomerEnity> customerEntities = customerRepository.findAll();
		List<Customer> customers = new ArrayList<Customer>();
		for(CustomerEnity cee: customerEntities) {
			
			Customer c = new Customer();
			c.setUsername(cee.getUsername());
			c.setCustomerId(cee.getCustomerId());
			
			List<CustomerAddress> customerAddresses = new ArrayList<CustomerAddress>();
			for(CustomerAddressEntity cae: cee.getCustomerAddressEntities()) {
				CustomerAddress ca = new CustomerAddress();
				ca.setStreet(cae.getStreet());
				ca.setCity(cae.getCity());
				ca.setAddressId(cae.getAddressId());
				customerAddresses.add(ca);
			}
			
			c.setCustomerAddress(customerAddresses);
			customers.add(c);
				
		}
		return customers;
			
	}
	
	
	@PostMapping("/add")
	public List<Customer> addCustomerWithAddress(@RequestBody Customer customer) {
		System.out.println(customer.getUsername());
		CustomerEnity ce = new CustomerEnity();
		ce.setUsername(customer.getUsername());
		
		List<CustomerAddressEntity> caeList = new ArrayList<CustomerAddressEntity>();
		for(CustomerAddress ca: customer.getCustomerAddress()) {
			System.out.println(ca.getCity());
			CustomerAddressEntity cae = new CustomerAddressEntity();
			cae.setCity(ca.getCity());
			cae.setStreet(ca.getStreet());
			customAddressRepository.save(cae);
			caeList.add(cae);
		}
		
		ce.setCustomerAddressEntities(caeList);
		customerRepository.save(ce);
		
		
		List<CustomerEnity> customerEntities = customerRepository.findAll();
		List<Customer> customers = new ArrayList<Customer>();
		for(CustomerEnity cee: customerEntities) {
			
			Customer c = new Customer();
			c.setUsername(cee.getUsername());
			c.setCustomerId(cee.getCustomerId());
			
			List<CustomerAddress> customerAddresses = new ArrayList<CustomerAddress>();
			for(CustomerAddressEntity cae: cee.getCustomerAddressEntities()) {
				CustomerAddress ca = new CustomerAddress();
				ca.setStreet(cae.getStreet());
				ca.setCity(cae.getCity());
				ca.setAddressId(cae.getAddressId());
				customerAddresses.add(ca);
			}
			
			c.setCustomerAddress(customerAddresses);
			customers.add(c);
				
		}
		return customers;
		
		
	}
	
}
