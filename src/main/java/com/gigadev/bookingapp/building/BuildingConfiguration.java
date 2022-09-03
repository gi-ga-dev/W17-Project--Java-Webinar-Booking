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
		//return new Building("Palazzo Pitti", "Piazza de' Pitti, 1", "Firenze");	
		Building b1 = new Building();
		b1.setName("Palazzo Pitti");
		b1.setAddress("Piazza de' Pitti, 1");
		b1.setCity("Firenze");
		b1.addWorkstation(w1);
		b1.addWorkstation(w2);
		b1.addWorkstation(w3);
		b1.addWorkstation(w4);
		return b1;
	}
	
	@Bean("Building2")
	@Scope("singleton")
	public Building newBuilding2() {
		return new Building("Palazzo Madama", "Piazza Madama", "Roma");
	}
}
