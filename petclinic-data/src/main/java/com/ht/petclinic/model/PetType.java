package com.ht.petclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	public PetType() {
	}
	
	public PetType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
