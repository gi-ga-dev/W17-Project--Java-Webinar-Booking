package com.gigadev.bookingapp.workstation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.gigadev.bookingapp.booking.Booking;
import com.gigadev.bookingapp.building.Building;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Workstation {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private WorkstationType type;
	private int participants;
	
	@ManyToOne
	private Building building;
	
	@OneToMany(mappedBy = "workstation", cascade = CascadeType.PERSIST)
	private List<Booking> bookings = new ArrayList<>();
	
	public Workstation(String description, WorkstationType type, int participants) {
		super();
		this.description = description;
		this.type = type;
		this.participants = participants;
	}
		
}
