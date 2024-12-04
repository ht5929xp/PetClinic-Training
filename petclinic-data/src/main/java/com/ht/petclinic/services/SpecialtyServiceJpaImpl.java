package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.ht.petclinic.model.Specialty;
import com.ht.petclinic.repositories.SpecialtyRepository;

@Service
@Profile("jpa_impl")
public class SpecialtyServiceJpaImpl implements SpecialtyService {

	private SpecialtyRepository specialtyRepo;
	
	public SpecialtyServiceJpaImpl(SpecialtyRepository specialtyRepo) {
		super();
		this.specialtyRepo = specialtyRepo;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepo.findById(id).orElse(null);
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialtyTypes = new HashSet<>();
		Iterable<Specialty> petTypeIter = specialtyRepo.findAll();
		petTypeIter.iterator().forEachRemaining(specialtyTypes::add);	
		return specialtyTypes;
	}

	@Override
	public Specialty save(Specialty s) {
		return specialtyRepo.save(s);
	}

	@Override
	public void delete(Specialty s) {
		specialtyRepo.delete(s);
	}

	@Override
	public void deleteById(Long id) {
		
	}

}
