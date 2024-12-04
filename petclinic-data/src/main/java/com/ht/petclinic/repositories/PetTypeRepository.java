package com.ht.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ht.petclinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
