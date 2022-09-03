package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
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
	
	public List<Booking> searchByUserAndValidity(Long id, LocalDate validity) {
		return bookingRepo.findByUserAndValidity(id, validity);
	}
	
	public List<Booking> searchByWorkstationAndValidity(Long id, LocalDate validity) {
		return bookingRepo.findByWorkstationAndValidity(id, validity);
	}
	
	public void create(Booking booking) {	

		List<Booking> bookings = searchByUserAndValidity(booking.getUser().getId(), booking.getValidity());		
		List<Booking> bookingIfFree = searchByWorkstationAndValidity(booking.getWorkstation().getUniqueCode(), booking.getValidity());		
	
		if(bookings == null || bookings.size() == 0 && bookingIfFree == null || bookingIfFree.size() < booking.getWorkstation().getParticipants()) {
			bookingRepo.save(booking);
		}
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
