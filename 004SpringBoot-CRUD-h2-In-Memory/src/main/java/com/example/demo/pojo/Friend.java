package com.example.demo.pojo;

public class Friend {
	
	private Integer id;
	private String name;
	private String location;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Friend(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Friend() {
		super();
	}
	
	

}
