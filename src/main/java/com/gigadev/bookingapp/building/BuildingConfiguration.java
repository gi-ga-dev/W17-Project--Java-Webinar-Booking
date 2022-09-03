package com.gigadev.bookingapp.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gigadev.bookingapp.workstation.Workstation;

@Configuration
public class BuildingConfiguration {

	// recupera l'istanza della classe tramite il Bean
	@Autowired @Qualifier("Workstation1") Workstation w1;
	@Autowired @Qualifier("Workstation2") Workstation w2;
	@Autowired @Qualifier("Workstation3") Workstation w3;
	@Autowired @Qualifier("Workstation4") Workstation w4;
	
	private BuildingService buildingServ;

	@Bean("Building1")
	@Scope("singleton")
	public Building newBuilding1() {
		Building b1 = new Building("Palazzo Pitti", "Piazza de' Pitti, 1", "Firenze");	
		buildingServ.create(b1);		
		return b1;
	}
	
	@Bean("Building2")
	@Scope("singleton")
	public Building newBuilding2() {
		Building b2 = new Building("Palazzo Madama", "Piazza Madama", "Roma");
		buildingServ.create(b2);
		return b2;
	}
}
