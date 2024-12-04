package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Pet;

@Service
@Profile("map_impl")
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public void delete(Pet t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
