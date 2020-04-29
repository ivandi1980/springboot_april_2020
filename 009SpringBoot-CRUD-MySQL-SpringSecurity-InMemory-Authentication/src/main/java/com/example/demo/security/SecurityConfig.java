package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder 
	 * which required plain text passwords. In Spring Security 5, the default is 
	 * DelegatingPasswordEncoder, which required Password Storage Format.
	 * Add password storage format, for plain text, add {noop}
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}user1234")
				.roles("USER")
				.and()
				.withUser("manager")
				.password("{noop}manager1234")
				.roles("USER", "MANAGER")
				.and()
				.withUser("admin")
				.password("{noop}admin1234")
				.roles("USER", "MANAGER", "ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/friend/**").hasAnyRole("ADMIN", "MANAGER", "USER")
			.antMatchers(HttpMethod.POST, "/friend/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers(HttpMethod.PUT, "/friend/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers(HttpMethod.DELETE, "/friend/**").hasAnyRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
		
		
	}

}
