package com.gigadev.bookingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gigadev.bookingapp.building.BuildingConfiguration;
import com.gigadev.bookingapp.building.BuildingService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookingRunner implements ApplicationRunner {
	
	@Autowired
	BuildingService buildingServ;
	@Autowired
	BuildingConfiguration buildingConfig;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {		
		log.info("Application Started Successfully!!!");
		
		buildingServ.create(buildingConfig.newBuilding1());
	}

}
