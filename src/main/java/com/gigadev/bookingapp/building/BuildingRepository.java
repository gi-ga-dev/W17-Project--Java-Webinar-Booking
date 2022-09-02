package com.gigadev.bookingapp.building;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long>{
	
}
