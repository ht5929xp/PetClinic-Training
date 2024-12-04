package com.ht.petclinic.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Visit;
import com.ht.petclinic.repositories.VisitRepository;

@Service
@Profile("jpa_impl")
public class VisitServiceJpaImpl implements VisitService {

	private VisitRepository visitRepo;

	public VisitServiceJpaImpl(VisitRepository visitRepo) {
		super();
		this.visitRepo = visitRepo;
	}

	@Override
	public void delete(Visit t) {
		visitRepo.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		visitRepo.deleteById(id);
		
	}

	@Override
	public Visit findById(Long id) {
		return visitRepo.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		Iterable<Visit> visitIter = visitRepo.findAll();
		visitIter.iterator().forEachRemaining(visits::add);	
		return visits;
	}

	@Override
	public Visit save(Visit t) {
		return visitRepo.save(t);
	}
}
