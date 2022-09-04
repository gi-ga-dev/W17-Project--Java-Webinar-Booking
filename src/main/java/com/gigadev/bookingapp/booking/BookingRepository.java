package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	// seleziona il conteggio dalla classe dove (condizione) e' rispettata (i parametri della Query)
	@Query("SELECT count(*) FROM Booking ele WHERE ele.user.id =:id AND ele.validity =:validity")
	public int findByUserAndValidity(Long id, LocalDate validity);
		
	@Query("SELECT count(*) FROM Booking ele WHERE ele.workstation.id =:id AND ele.validity =:validity")
	public int findByWorkstationAndValidity(Long id, LocalDate validity);
		
	
}
