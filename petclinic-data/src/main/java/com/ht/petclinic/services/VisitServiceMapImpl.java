package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Visit;

@Service
@Profile("map_impl")
public class VisitServiceMapImpl extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit save(Visit visit) {

		if (visit == null) {
			return visit;
		}

		if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Pet and Owner are required!");
		}

		return super.save(visit);
	}
	
	
	@Override
	public void delete(Visit t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


}
