package com.gigadev.bookingapp.workstation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WorkstationConfiguration {

	@Bean("Workstation1")
	@Scope("singleton")
	public Workstation newWorkstation1() {
		return new Workstation((long) 123, "Room for Digital Marketing Webinar", WorkstationType.OPENSPACE, 25);
	}
	
	@Bean("Workstation2")
	@Scope("singleton")
	public Workstation newWorkstation2() {
		return new Workstation((long) 456, "Room for Senior Assistance", WorkstationType.MEETING_ROOM, 50);
	}
	
	@Bean("Workstation3")
	@Scope("singleton")
	public Workstation newWorkstation3() {
		return new Workstation((long) 789, "Room for Leisure Activity", WorkstationType.PRIVATE, 5);
	}
	
	@Bean("Workstation4")
	@Scope("singleton")
	public Workstation newWorkstation4() {
		return new Workstation((long) 159, "Room for Morning Brainstorming", WorkstationType.OPENSPACE, 15);
	}
	
}
