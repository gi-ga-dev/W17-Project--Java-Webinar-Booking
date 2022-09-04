package com.gigadev.bookingapp.building;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.gigadev.bookingapp.workstation.Workstation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Building {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String city;
	
	// se all'interno di un building trova le postazioni, con persist salva anche quelle
	@OneToMany(cascade = CascadeType.PERSIST)
	// per riportare building_id (del table dell'associazione building-workstation creato a parte) nel table workstation
	@JoinColumn(name = "building_id")
	private List<Workstation> workstations = new ArrayList<>();
	
	public Building(String name, String address, String city) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
	}	
	
	public void addWorkstation(Workstation workstation) {
		workstations.add(workstation);
	}
	
}
