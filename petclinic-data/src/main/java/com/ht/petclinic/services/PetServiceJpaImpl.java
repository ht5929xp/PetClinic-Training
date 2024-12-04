package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Pet;
import com.ht.petclinic.repositories.PetRepository;

@Service
@Profile("jpa_impl")
public class PetServiceJpaImpl implements PetService {

	private PetRepository petRepo;

	public PetServiceJpaImpl(PetRepository petRepo) {
		super();
		this.petRepo = petRepo;
	}

	@Override
	public Pet findById(Long id) {
		return petRepo.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet p) {
		return petRepo.save(p);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		Iterable<Pet> ownerIter = petRepo.findAll();
		ownerIter.iterator().forEachRemaining(pets::add);	
		return pets;
	}

}
