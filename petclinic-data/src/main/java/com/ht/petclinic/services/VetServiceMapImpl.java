package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Specialty;
import com.ht.petclinic.model.Vet;

@Service
@Profile("map_impl")
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {
	
	SpecialtyService specialtyService;

	public VetServiceMapImpl(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet vet) {

		if (vet == null) {
			return vet;
		}

		if (vet.getSpecialities() != null) {
			vet.getSpecialities().forEach(s -> {
				if (s.getId() == null) {
					Specialty savedSpecialty = specialtyService.save(s);
					s.setId(savedSpecialty.getId());
				}
			});
		}

		return super.save(vet);
	}

	@Override
	public void delete(Vet t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
}
