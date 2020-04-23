package com.example.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@EntityScan(basePackages = {"com.example.entity"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
public class MainEntry {
	
	
	public static void main(String args[]) {
		SpringApplication.run(MainEntry.class, args);
	}

}
