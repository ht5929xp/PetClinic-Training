package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Owner;
import com.ht.petclinic.repositories.OwnerRepository;

@Service
@Profile("jpa_impl")
public class OwnerServiceJpaImpl implements OwnerService {

	private final OwnerRepository ownerRepo;
	
	public OwnerServiceJpaImpl(OwnerRepository ownerRepo) {
		super();
		this.ownerRepo = ownerRepo;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepo.findById(id).orElse(null);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		Iterable<Owner> ownerIter = ownerRepo.findAll();
		ownerIter.iterator().forEachRemaining(owners::add);	
		return owners;
	}

	@Override
	public Owner save(Owner t) {
		return ownerRepo.save(t);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepo.findByLastName(lastName);
	}

	@Override
	public void delete(Owner o) {
		ownerRepo.delete(o);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepo.deleteById(id);
	}

}
