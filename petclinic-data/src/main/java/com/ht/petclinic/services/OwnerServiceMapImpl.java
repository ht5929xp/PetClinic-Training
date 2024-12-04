package com.ht.petclinic.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ht.petclinic.model.Owner;
import com.ht.petclinic.model.Pet;
import com.ht.petclinic.model.PetType;

@Service
@Profile("map_impl")
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMapImpl(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner owner) {

		if (owner == null) {
			return owner;
		}

		if (owner.getPets() != null) {
			owner.getPets().forEach(p -> {
				if (p.getPetType() != null && p.getPetType().getId() == null) {
					PetType savedPetType = petTypeService.save(p.getPetType());
					p.getPetType().setId(savedPetType.getId());
				} else if(p.getPetType() == null) {
					throw new RuntimeException("Pet Type is required!");
				}

				if (p.getId() == null) {
					Pet savedPet = petService.save(p);
					p.setId(savedPet.getId());
				}
			});
		}

		return super.save(owner);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Owner t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
}
