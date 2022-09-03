package com.gigadev.bookingapp.booking;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BookingConfiguration {
	
	@Bean("booking1")
	@Scope("singleton")
	public Booking newBooking1() {
		return new Booking(null, null, LocalDate.now());
	}
	
	

}
