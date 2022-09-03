package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
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
@RequestMapping("/bookings")
@Slf4j
public class BookingController {
	
	@Autowired
	private BookingService bookingServ;
	
	// http://localhost:8080/bookings
	@GetMapping
	public List<Booking> searchAllBookings() {	
		try { return bookingServ.searchAllBookings(); } 
		catch (Exception e) {
			log.error("Searching all bookings unsuccessful");
			return new ArrayList<Booking>();
		}		
	}	
	
	@GetMapping("/searchByUserAndValidity")
	public List<Booking> searchByUserAndValidity(@RequestParam Long id, @RequestParam LocalDate validity) {
		try { return bookingServ.searchByUserAndValidity(id, validity); } 
		catch (Exception e) {
			log.error("Searching bookings by user and validity unsuccessful");
			return new ArrayList<Booking>();
		}		
	}
	
	@PostMapping
	public void create(@RequestBody Booking booking) {
		try { bookingServ.create(booking); } 
		catch (Exception e) { log.error("Creation unsuccessful..."); }		
	}
	
	// http://localhost:8080/booking/id	
	@GetMapping("/{id}")
	public Booking readById(@PathVariable Long id) {
		try { return bookingServ.read(id); } 
		catch (Exception e) {
			log.error("Reading by id unsuccessful...");
			return new Booking();
		}		
	}
		
	@PutMapping
	public void update(@RequestBody Booking booking) {
		try { bookingServ.update(booking); } 
		catch (Exception e) { log.error("Update unsuccessful..."); }		
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		try { bookingServ.delete(id); } 
		catch (Exception e) { log.error("Delete by id unsuccessful..."); }		
	}

}
