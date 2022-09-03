package com.gigadev.bookingapp.booking;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import com.gigadev.bookingapp.user.User;
import com.gigadev.bookingapp.workstation.Workstation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate validity;
	
	@ManyToOne
	private Workstation workstation;	
	@ManyToOne
	private User user;
	
	public Booking(Workstation workstation, User user, LocalDate validity) {
		super();
		this.workstation = workstation;
		this.user = user;
		this.validity = validity;
	}
	
	
}
