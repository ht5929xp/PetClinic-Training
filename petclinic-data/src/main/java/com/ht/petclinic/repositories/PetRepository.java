package com.ht.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ht.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
