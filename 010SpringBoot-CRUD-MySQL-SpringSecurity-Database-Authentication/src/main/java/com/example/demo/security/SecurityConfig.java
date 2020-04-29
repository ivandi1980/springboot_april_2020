package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailService;
	

	
	
	/*
	 * Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder 
	 * which required plain text passwords. In Spring Security 5, the default is 
	 * DelegatingPasswordEncoder, which required Password Storage Format.
	 * Add password storage format, for plain text, add {noop}
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				/*
				 * .antMatchers(HttpMethod.GET, "/friend/**").hasAnyRole("ADMIN", "MANAGER",
				 * "USER") .antMatchers(HttpMethod.POST, "/friend/**").hasAnyRole("ADMIN",
				 * "MANAGER") .antMatchers(HttpMethod.PUT, "/friend/**").hasAnyRole("ADMIN",
				 * "MANAGER") .antMatchers(HttpMethod.DELETE, "/friend/**").hasAnyRole("ADMIN")
				 */
		.antMatchers("/friend/**").hasAnyRole("ADMIN", "MANAGER", "USER")
		.antMatchers("/add/**").hasAnyRole("ADMIN", "MANAGER")
		.antMatchers("/update/**").hasAnyRole("ADMIN", "MANAGER")
		.antMatchers("/delete/**").hasAnyRole("ADMIN")
		.and()
			.httpBasic();
		//	.and()
		//	.csrf().disable();
		
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailService);
		
		return daoAuthenticationProvider;
	}
	

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	

}
