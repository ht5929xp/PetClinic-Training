package com.ht.petclinic.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ht.petclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
	public Optional<Owner> findById(Long id);
	
	public Owner findByLastName(String lastName);
}
