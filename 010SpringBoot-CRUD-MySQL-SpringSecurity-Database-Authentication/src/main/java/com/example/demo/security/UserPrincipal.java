package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;

public class UserPrincipal implements UserDetails{
	
	@Autowired
	private User user;
	
	
	public UserPrincipal(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		this.user.getRolesAsList().forEach( role ->{
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
			authorities.add(authority);
		});
		
		return authorities;
		
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println(this.user.getPassword());
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println(this.user.getUsername());
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		//return this.user.getActive() == 1;
		return true;
	}

}
