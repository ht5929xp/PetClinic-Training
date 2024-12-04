package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Specialty;

@Service
@Profile("map_impl")
public class SpecialtyServiceMapImpl extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public void delete(Specialty t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
