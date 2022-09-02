package com.gigadev.bookingapp.booking;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;
	
	public List<Booking> searchAllBookings() {		
		return (List<Booking>) bookingRepo.findAll();
	}
	
	public void create(Booking booking) {
		bookingRepo.save(booking);
	}
	
	public Booking read(Long id) {
		return bookingRepo.findById(id).get();
	}
	
	public void update(Booking booking) {
		bookingRepo.save(booking);
	}
	
	public void delete(Long id) {
		bookingRepo.deleteById(id);
	}

}
