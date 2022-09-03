package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.gigadev.bookingapp.user.User;
import com.gigadev.bookingapp.workstation.Workstation;

@Configuration
public class BookingConfiguration {
	
	// recupera l'istanza della classe tramite il Bean
	@Autowired @Qualifier("workstation1") Workstation w1;
	@Autowired @Qualifier("workstation2") Workstation w2;
	@Autowired @Qualifier("workstation3") Workstation w3;
	@Autowired @Qualifier("workstation4") Workstation w4;
	
	@Autowired @Qualifier("user1") User u1;
	@Autowired @Qualifier("user2") User u2;
	
	@Bean("booking1")
	@Scope("singleton")
	public Booking newBooking1() {
		return new Booking(w1, u1, LocalDate.now());
	}
	
	@Bean("booking2")
	@Scope("singleton")
	public Booking newBooking2() {
		return new Booking(w2, u1, LocalDate.now());
	}
	
	@Bean("booking3")
	@Scope("singleton")
	public Booking newBooking3() {
		return new Booking(w1, u2, LocalDate.now());
	}
	
	@Bean("booking4")
	@Scope("singleton")
	public Booking newBooking4() {
		return new Booking(w4, u2, LocalDate.now());
	}

}
