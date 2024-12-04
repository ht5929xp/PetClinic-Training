package com.ht.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ht.petclinic.model.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {

}
