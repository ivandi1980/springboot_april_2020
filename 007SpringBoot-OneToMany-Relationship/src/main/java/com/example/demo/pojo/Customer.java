package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.CustomerAddressEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	private Integer customerId;
	private String username;
    private List<CustomerAddress> customerAddress = new ArrayList<CustomerAddress>();
	

}
