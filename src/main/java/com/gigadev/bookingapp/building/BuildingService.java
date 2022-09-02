package com.gigadev.bookingapp.building;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepo;
	
	public List<Building> searchAllBuildings() {		
		return (List<Building>) buildingRepo.findAll();
	}
	
	public void create(Building building) {
		buildingRepo.save(building);
	}
	
	public Building read(Long id) {
		return buildingRepo.findById(id).get();
	}
	
	public void update(Building building) {
		buildingRepo.save(building);
	}
	
	public void delete(Long id) {
		buildingRepo.deleteById(id);
	}

}
