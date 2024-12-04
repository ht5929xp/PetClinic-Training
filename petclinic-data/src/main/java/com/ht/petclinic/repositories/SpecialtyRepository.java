package com.ht.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ht.petclinic.model.Specialty;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
