package com.ht.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ht.petclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
