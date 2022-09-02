package com.gigadev.bookingapp.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookingConfiguration {
	
	@Bean("BookingBean")
	@Scope("prototype")
	public Booking newBooking() {
		Booking booking = new Booking();
		
		
		return booking;
	}
	

}
