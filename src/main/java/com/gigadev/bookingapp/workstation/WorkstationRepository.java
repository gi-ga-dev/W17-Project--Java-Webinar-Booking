package com.gigadev.bookingapp.workstation;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationRepository extends CrudRepository<Workstation, Long>{	
	
	@Query("SELECT ele FROM Workstation ele WHERE ele.building.city =:city AND ele.type =:type")
	public List<Workstation> findByCityAndType(String city, WorkstationType type);
	
}
