package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Customer")
public class CustomerEnity {
	
	@Id
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "user_name")
	private String username;
	
	@OneToMany
	@JoinTable(name = "customer_address_mapping",
				joinColumns = @JoinColumn(name="customer_id"), 
				inverseJoinColumns = @JoinColumn(name = "address_id"))
	private Collection<CustomerAddressEntity> customerAddressEntities = new ArrayList<CustomerAddressEntity>();

}
