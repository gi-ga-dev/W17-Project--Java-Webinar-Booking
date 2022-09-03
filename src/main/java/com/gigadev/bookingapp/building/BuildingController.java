package com.gigadev.bookingapp.building;

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
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/buildings")
@Slf4j
public class BuildingController {

	@Autowired
	private BuildingService buildingServ;

	// http://localhost:8080/buildings
	@GetMapping
	public List<Building> searchAllBuildings() {
		try { return buildingServ.searchAllBuildings(); } 
		catch (Exception e) {
			log.error("Searching all buildings unsuccessful");
			return new ArrayList<Building>();
		}		
	}

	@PostMapping
	public void create(@RequestBody Building building) {
		try { buildingServ.create(building); } 
		catch (Exception e) { log.error("Creation unsuccessful..."); }		
	}

	// http://localhost:8080/buildings/id
	@GetMapping("/{id}")
	public Building readById(@PathVariable Long id) {
		try { return buildingServ.read(id);	} 
		catch (Exception e) {
			log.error("Reading by id unsuccessful...");
			return new Building();
		}		
	}

	@PutMapping
	public void update(@RequestBody Building building) {
		try { buildingServ.update(building); } 
		catch (Exception e) { log.error("Update unsuccessful..."); }		
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		try { buildingServ.delete(id); } 
		catch (Exception e) { log.error("Delete by id unsuccessful..."); }
	}

}
