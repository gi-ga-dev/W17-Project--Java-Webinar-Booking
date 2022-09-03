package com.gigadev.bookingapp.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConfiguration {

	@Bean("user1")
	@Scope("singleton")
	public User newUser1() {
		return new User("user1", "Gianluca", "gianluke@gmail.com");
	}
	
	@Bean("user2")
	@Scope("singleton")
	public User newUser2() {
		return new User("user2", "Aculnaig", "lukegian@gmail.com");
	}
}
