package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	public List<Booking> searchAllBookings() {
		return (List<Booking>) bookingRepo.findAll();
	}
	
	// cerca tutte le prenotazioni effettuate
	public List<Booking> searchByUserAndValidity(Long id, LocalDate validity) {
		List<Booking> retList = bookingRepo.findByUserAndValidity(id, validity);
		log.info("@@@ The user has booked " + retList.size() + "workstation/s");
		return retList;
	}

	public List<Booking> searchByWorkstationAndValidity(Long id, LocalDate validity) {
		return bookingRepo.findByWorkstationAndValidity(id, validity);
	}

	public void create(Booking booking) {
		// utilizzare il ritorno del metodo della query per passarla all'attributo
		List<Booking> bookings = searchByUserAndValidity(booking.getUser().getId(), booking.getValidity());
		List<Booking> bookings2 = searchByWorkstationAndValidity(booking.getWorkstation().getId(),
				booking.getValidity());
		// se non ha prenotato in quel giorno
		if (bookings == null || bookings.size() == 0) {
			// se il numero attuale di prenotazioni della workstation e' inferiore al numero massimo dei posti salva nel db
			if (bookings2 == null || bookings2.size() < booking.getWorkstation().getParticipants()) {
				bookingRepo.save(booking);
				log.info("---> " + booking.getUser().getUsername() + " has booked the workstation "
						+ booking.getWorkstation().getDescription());
			} else {
				log.error("Workstation full");
			}
		} else {
			log.error("You have already booked a seat for today");
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
