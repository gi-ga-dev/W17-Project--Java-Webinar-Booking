package com.gigadev.bookingapp.workstation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkstationService {

	@Autowired
	private WorkstationRepository workstationRepo;
	
	public List<Workstation> searchWorkstation(String city, WorkstationType type) {
		return workstationRepo.findByCityAndType(city, type);
	}
	
	public List<Workstation> searchAllWorkstations() {		
		return (List<Workstation>) workstationRepo.findAll();
	}
	
	public void create(Workstation workstation) {
		workstationRepo.save(workstation);
	}
	
	public Workstation read(Long id) {
		return workstationRepo.findById(id).get();
	}
	
	public void update(Workstation workstation) {
		workstationRepo.save(workstation);
	}
	
	public void delete(Long id) {
		workstationRepo.deleteById(id);
	}
}
