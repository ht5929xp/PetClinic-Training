package com.ht.petclinic.loader;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ht.petclinic.model.Owner;
import com.ht.petclinic.model.Pet;
import com.ht.petclinic.model.PetType;
import com.ht.petclinic.model.Specialty;
import com.ht.petclinic.model.Vet;
import com.ht.petclinic.model.Visit;
import com.ht.petclinic.services.OwnerService;
import com.ht.petclinic.services.PetTypeService;
import com.ht.petclinic.services.SpecialtyService;
import com.ht.petclinic.services.VetService;
import com.ht.petclinic.services.VisitService;

@Component
public class Initializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	@Autowired
	public Initializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("here!!!");
		
		PetType dogType = petTypeService.save(new PetType("Dog"));
		PetType catType = petTypeService.save(new PetType("Cat"));
		PetType lionType = petTypeService.save(new PetType("Lion"));
		
		petTypeService.findAll().forEach((pt) -> System.out.println("Pet Type: " + pt.getName()));
		
		Specialty surgery = specialtyService.save(new Specialty("Surgery"));
		Specialty generalCare = specialtyService.save(new Specialty("General Care"));
		
		specialtyService.findAll().forEach((s) -> System.out.println("Specialty: " + s.getDescription()));
		
		Owner o1 = new Owner("Test", "Test Last Name");
		o1.setAddress("123 Test");
		o1.setCity("Test City");
		o1.setTelephone("123");
		
		Owner o2 = new Owner("Test 2", "Test Last Name 2");
		o2.setAddress("123 Test 2");
		o2.setCity("Test City 2");
		o2.setTelephone("234");
		
		Pet o1Cat = new Pet("Mochi", catType);
		o1Cat.setOwner(o1);
		Pet o1Dog = new Pet("Burnem", dogType);
		o1Dog.setOwner(o1);
	
		o1.getPets().add(o1Cat);
		o1.getPets().add(o1Dog);
				
		ownerService.save(o1);
		ownerService.save(o2);
		
		Vet vet1 = new Vet("Vet1", "Vet 1 Last Name");
		Vet vet2 = new Vet("Vet2", "Vet 2 Last Name");
		
		vet1.getSpecialities().add(generalCare);
		vet2.getSpecialities().add(surgery);
		
		vetService.save(vet1);
		vetService.save(vet2);
		
		ownerService.findAll().forEach(o -> {
			System.out.println(o.getFirstName() + "   " + o.getLastName());
			if(o.getPets() != null) {
				System.out.println("Pets:");
				o.getPets().forEach(p -> System.out.println("\t - " + p.getId() + "   " + p.getName() + "   " + p.getPetType().getName()));
			}
		});
		
		vetService.findAll().forEach(v -> {
			System.out.println(v.getFirstName() + "   " + v.getLastName());
			if (v.getSpecialities() != null) {
				System.out.println("Specialties:");
				v.getSpecialities().forEach(s -> System.out.println("\t - " + s.getId() + "   " + s.getDescription()));
			}
		});

		Visit o1Visit = new Visit();
		o1Visit.setDate(LocalDate.of(2020, 1, 8));
		o1Visit.setDescription("Routine cat checkup");
		o1Visit.setPet(o1Cat);
		
		visitService.save(o1Visit);
	}

}
