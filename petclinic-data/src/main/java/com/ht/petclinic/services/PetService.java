package com.ht.petclinic.services;

import java.util.Set;

import com.ht.petclinic.model.Pet;

public interface PetService {
	Pet findById(Long id);
		
	Pet save(Pet p);
	
	Set<Pet> findAll();
}
