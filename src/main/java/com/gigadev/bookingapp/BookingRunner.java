package com.gigadev.bookingapp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gigadev.bookingapp.booking.Booking;
import com.gigadev.bookingapp.booking.BookingConfiguration;
import com.gigadev.bookingapp.booking.BookingService;
import com.gigadev.bookingapp.building.BuildingConfiguration;
import com.gigadev.bookingapp.building.BuildingService;
import com.gigadev.bookingapp.user.UserConfiguration;
import com.gigadev.bookingapp.user.UserService;
import com.gigadev.bookingapp.workstation.WorkstationConfiguration;
import com.gigadev.bookingapp.workstation.WorkstationService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookingRunner implements ApplicationRunner {
	
	@Autowired
	BuildingService buildingServ;
	@Autowired
	BuildingConfiguration buildingConfig;
	
	@Autowired
	UserService userServ;
	@Autowired
	UserConfiguration userConfig;
	
	@Autowired
	BookingService bookingServ;
	@Autowired
	BookingConfiguration bookingConfig;
	
	@Autowired
	WorkstationService workstationServ;
	@Autowired
	WorkstationConfiguration workstationConfig;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {		
		log.info("Application Started Successfully!!!");
				
		// Creazione edificio con postazioni al suo interno
		buildingServ.create(buildingConfig.newBuilding1());
		buildingServ.create(buildingConfig.newBuilding2());
		
		// Creazione utenti
		userServ.create(userConfig.newUser1());
		userServ.create(userConfig.newUser2());
		
		// Creazione prenotazione user1
		bookingServ.create(bookingConfig.newBooking1()); // --->user1 has booked the workstation Room for Digital Marketing Webinar
		bookingServ.create(bookingConfig.newBooking2()); // You have already booked a seat for today	
		// Creazione prenotazione user2
		bookingServ.create(bookingConfig.newBooking3()); // Workstation full
		bookingServ.create(bookingConfig.newBooking4()); // --->user2 has booked the workstation Room for Morning Brainstorming
				
		// Cerca prenotazione in base id prenotazione e data
		bookingServ.searchByUserAndValidity((long) 1, LocalDate.now());
		
	}

}
