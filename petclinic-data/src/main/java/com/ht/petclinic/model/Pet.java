package com.ht.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	private PetType petType;
	
	@Column(name = "birth_date")
	private LocalDate birthday;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
	private Set<Visit> visits = new HashSet<>();
	
	public Pet() {
	}
	
	public Pet(String name, PetType petType) {
		super();
		this.petType = petType;
		this.name = name;
	}
	
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
}
