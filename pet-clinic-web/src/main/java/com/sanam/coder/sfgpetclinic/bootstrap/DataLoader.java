package com.sanam.coder.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Pet;
import com.sanam.coder.sfgpetclinic.model.PetType;
import com.sanam.coder.sfgpetclinic.model.Speciality;
import com.sanam.coder.sfgpetclinic.model.Vet;
import com.sanam.coder.sfgpetclinic.model.Visit;
import com.sanam.coder.sfgpetclinic.services.OwnerService;
import com.sanam.coder.sfgpetclinic.services.PetService;
import com.sanam.coder.sfgpetclinic.services.PetTypeService;
import com.sanam.coder.sfgpetclinic.services.SpecialityService;
import com.sanam.coder.sfgpetclinic.services.VetService;
import com.sanam.coder.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialtyService;
	private final VisitService visitService;
	
	
	
	
	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService,
			SpecialityService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();

        if (count == 0 ){
            loadData();
        }
		
		
		
	}
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialtyService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialtyService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDentistry = specialtyService.save(dentistry);
		
		
		Owner owner1 = Owner.builder().firstName("Kaleen").lastName("Bhaiya").address("123 Brickerlane")
				.city("Mirzapur").telephone("123-456-789").build();
		
		Pet mikesPet = Pet.builder().petType(savedDogPetType).owner(owner1).birthDate(LocalDate.now())
							.name("Rosco").build();
		owner1.getPets().add(mikesPet);
		
		
		ownerService.save(owner1);
		
		Owner owner2 = Owner.builder().firstName("Guddu").lastName("Pandit").address("7 Avenue Street")
			.city("New york").telephone("0111-456-789").build();
			
		
		Pet gudduPet = Pet.builder().petType(savedCatPetType).owner(owner2).birthDate(LocalDate.now())
				.name("Tawde").build();
		
		owner2.getPets().add(gudduPet);
		
		ownerService.save(owner2);
		
		Owner owner3 = Owner.builder().firstName("Bablu").lastName("Pandit").address("123 Magadh")
				.city("Dwarka").telephone("1235-456-789").build();
		
		Pet babluPet = Pet.builder().petType(savedDogPetType).owner(owner3).birthDate(LocalDate.now())
							.name("Zayn").build();
		owner3.getPets().add(babluPet);
		
		
		ownerService.save(owner3);

		Visit catVisit = new Visit();
		catVisit.setPet(gudduPet);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);
		
		System.out.println("Loaded Owners..");
		
		
		Vet vet1 = Vet.builder().firstName("Rashid").lastName("Khan").build();
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = Vet.builder().firstName("Henry").lastName("Klasen").build();
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
		System.out.println("Loaded Vets..");
	}

}
