package com.gigadev.bookingapp.workstation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workstations")
public class WorkstationController {
	
	@Autowired
	private WorkstationService workstationServ;

	// http://localhost:8080/workstations
	@GetMapping
	public List<Workstation> searchAllWorkstations() {
		return workstationServ.searchAllWorkstations();
	}
	
	@GetMapping("/searchByCityAndType")
	public List<Workstation> searchByCityAndType(@RequestParam String city, @RequestParam WorkstationType type) {
		return workstationServ.searchWorkstation(city, type);
	}

	@PostMapping
	public void create(@RequestBody Workstation workstation) {
		workstationServ.create(workstation);
	}

	// http://localhost:8080/workstations/id
	@GetMapping("/{id}")
	public Workstation readById(@PathVariable Long id) {
		return workstationServ.read(id);
	}

	@PutMapping
	public void update(@RequestBody Workstation workstation) {
		workstationServ.update(workstation);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		workstationServ.delete(id);
	}

}
