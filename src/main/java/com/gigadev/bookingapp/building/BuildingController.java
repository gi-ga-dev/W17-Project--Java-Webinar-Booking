package com.gigadev.bookingapp.building;

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

@RestController
@RequestMapping("/buildings")
public class BuildingController {

	@Autowired
	private BuildingService buildingServ;

	// http://localhost:8080/buildings
	@GetMapping
	public List<Building> searchAllBuildings() {
		return buildingServ.searchAllBuildings();
	}

	@PostMapping
	public void create(@RequestBody Building building) {
		buildingServ.create(building);
	}

	// http://localhost:8080/buildings/id
	@GetMapping("/{id}")
	public Building readById(@PathVariable Long id) {
		return buildingServ.read(id);
	}

	@PutMapping
	public void update(@RequestBody Building building) {
		buildingServ.update(building);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		buildingServ.delete(id);
	}

}
