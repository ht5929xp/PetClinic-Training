package com.ht.petclinic.services;

import com.ht.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	public Owner findByLastName(String lastName);
	
	
}
