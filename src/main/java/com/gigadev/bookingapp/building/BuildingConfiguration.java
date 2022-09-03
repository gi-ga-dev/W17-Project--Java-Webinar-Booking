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
	@Autowired @Qualifier("workstation1") Workstation w1;
	@Autowired @Qualifier("workstation2") Workstation w2;
	@Autowired @Qualifier("workstation3") Workstation w3;
	@Autowired @Qualifier("workstation4") Workstation w4;

	@Bean("building1")
	@Scope("singleton")
	public Building newBuilding1() {
		Building b1 = new Building("Palazzo Pitti", "Piazza de' Pitti, 1", "Firenze");
		b1.addWorkstation(w1);
		b1.addWorkstation(w2);
		return b1;
	}
	
	@Bean("building2")
	@Scope("singleton")
	public Building newBuilding2() {
		Building b2 = new Building("Palazzo Madama", "Piazza Madama", "Roma");
		b2.addWorkstation(w3);
		b2.addWorkstation(w4);
		return b2;
	}
}
