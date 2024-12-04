package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.PetType;
import com.ht.petclinic.repositories.PetTypeRepository;

@Service
@Profile("jpa_impl")
public class PetTypeServiceJpaImpl implements PetTypeService {

	private PetTypeRepository petTypeRepo;
	
	public PetTypeServiceJpaImpl(PetTypeRepository petTypeRepo) {
		super();
		this.petTypeRepo = petTypeRepo;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepo.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		Iterable<PetType> petTypeIter = petTypeRepo.findAll();
		petTypeIter.iterator().forEachRemaining(petTypes::add);	
		return petTypes;
	}

	@Override
	public PetType save(PetType t) {
		return petTypeRepo.save(t);
	}

	@Override
	public void delete(PetType t) {
		petTypeRepo.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepo.deleteById(id);
	}

}
