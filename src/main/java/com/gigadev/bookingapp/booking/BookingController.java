package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
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
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingServ;
	
	// http://localhost:8080/bookings
	@GetMapping
	public List<Booking> searchAllBookings() {		
		return bookingServ.searchAllBookings();
	}	
	
	@GetMapping("/searchByUserAndValidity")
	public List<Booking> searchByUserAndValidity(@RequestParam Long id, @RequestParam LocalDate validity) {
		return bookingServ.searchByUserAndValidity(id, validity);
	}
	
	@PostMapping
	public void create(@RequestBody Booking booking) {
		bookingServ.create(booking);
	}
	
	// http://localhost:8080/booking/id	
	@GetMapping("/{id}")
	public Booking readById(@PathVariable Long id) {
		return bookingServ.read(id);
	}
		
	@PutMapping
	public void update(@RequestBody Booking booking) {
		bookingServ.update(booking);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		bookingServ.delete(id);
	}

}
