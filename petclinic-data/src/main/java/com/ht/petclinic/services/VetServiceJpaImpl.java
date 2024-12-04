package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Vet;
import com.ht.petclinic.repositories.VetRepository;

@Service
@Profile("jpa_impl")
public class VetServiceJpaImpl implements VetService {

	private VetRepository vetRepo;

	public VetServiceJpaImpl(VetRepository vetRepo) {
		super();
		this.vetRepo = vetRepo;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepo.findById(id).orElse(null);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vetTypes = new HashSet<>();
		Iterable<Vet> petTypeIter = vetRepo.findAll();
		petTypeIter.iterator().forEachRemaining(vetTypes::add);	
		return vetTypes;
	}

	@Override
	public Vet save(Vet v) {
		return vetRepo.save(v);
	}

	@Override
	public void delete(Vet v) {
		vetRepo.delete(v);
	}

	@Override
	public void deleteById(Long id) {
		vetRepo.deleteById(id);
	}
}
