package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.PetType;

@Service
@Profile("map_impl")
public class PetTypeServiceMapImpl extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
	public void delete(PetType t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
