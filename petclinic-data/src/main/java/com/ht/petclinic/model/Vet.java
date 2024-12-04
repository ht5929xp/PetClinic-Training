package com.ht.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties", joinColumns = {@JoinColumn(name = "vet_id")}, inverseJoinColumns = {@JoinColumn(name = "specialty_id")})
	private Set<Specialty> specialities = new HashSet<>();
	
	public Vet() {
	}
	
	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Set<Specialty> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Specialty> specialities) {
		this.specialities = specialities;
	}
}
