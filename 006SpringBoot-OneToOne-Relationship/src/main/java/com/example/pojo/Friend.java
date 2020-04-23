package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
	
	private Integer friendId;
	private String firstName;
	private String lastName;
	private FriendProfile profile;

}
