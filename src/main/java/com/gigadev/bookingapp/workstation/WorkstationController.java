package com.gigadev.bookingapp.workstation;

import java.util.ArrayList;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/workstations")
@Slf4j
public class WorkstationController {
	
	@Autowired
	private WorkstationService workstationServ;

	// http://localhost:8080/workstations
	@GetMapping
	public List<Workstation> searchAllWorkstations() {
		try { return workstationServ.searchAllWorkstations();} 
		catch (Exception e) {
			log.error("Searching all workstations unsuccessful..."); 
			return new ArrayList<Workstation>();
		}
		
	}
	
	@GetMapping("/searchByCityAndType")
	public List<Workstation> searchByCityAndType(@RequestParam String city, @RequestParam WorkstationType type) {
		try { return workstationServ.searchWorkstation(city, type);	} 
		catch (Exception e) {
			log.error("Searching by city and type unsuccessful..."); 
			return new ArrayList<Workstation>();
		}		
	}

	@PostMapping
	public void create(@RequestBody Workstation workstation) {
		try { workstationServ.create(workstation); } 
		catch (Exception e) { log.error("Creation unsuccessful..."); }		
	}

	// http://localhost:8080/workstations/id
	@GetMapping("/{id}")
	public Workstation readById(@PathVariable Long id) {
		try { return workstationServ.read(id); } 
		catch (Exception e) { 
			log.error("Reading by id unsuccessful..."); 
			return new Workstation();
		}		
	}

	@PutMapping
	public void update(@RequestBody Workstation workstation) {
		try { workstationServ.update(workstation); } 
		catch (Exception e) { log.error("Update unsuccessful..."); }		
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		try { workstationServ.delete(id); } 
		catch (Exception e) { log.error("Delete by id unsuccessful..."); }		
	}

}
