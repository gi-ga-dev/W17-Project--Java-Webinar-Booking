package com.gigadev.bookingapp.workstation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WorkstationConfiguration {

	@Bean("workstation1")
	@Scope("singleton")
	public Workstation newWorkstation1() {
		return new Workstation("Room for Digital Marketing Webinar", WorkstationType.PRIVATE, 1);
	}
	
	@Bean("workstation2")
	@Scope("singleton")
	public Workstation newWorkstation2() {
		return new Workstation("Room for Senior Assistance", WorkstationType.MEETING_ROOM, 50);
	}
	
	@Bean("workstation3")
	@Scope("singleton")
	public Workstation newWorkstation3() {
		return new Workstation("Room for Leisure Activity", WorkstationType.OPENSPACE, 25);
	}
	
	@Bean("workstation4")
	@Scope("singleton")
	public Workstation newWorkstation4() {
		return new Workstation("Room for Morning Brainstorming", WorkstationType.OPENSPACE, 15);
	}
	
}
