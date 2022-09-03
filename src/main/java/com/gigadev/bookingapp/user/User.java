package com.gigadev.bookingapp.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gigadev.bookingapp.booking.Booking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Booking> bookings = new ArrayList<>();
	
	public User(String username, String name, String email) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
}
