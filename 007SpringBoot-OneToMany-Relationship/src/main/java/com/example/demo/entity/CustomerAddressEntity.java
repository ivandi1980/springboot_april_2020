package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Customer_Address")
public class CustomerAddressEntity {
	
	@Id
	@Column(name = "address_id")
	private Integer addressId;
	@Column
	private String street;
	@Column
	private String city;

}
