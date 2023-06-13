package com.sanam.coder.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Pet;
import com.sanam.coder.sfgpetclinic.model.PetType;
import com.sanam.coder.sfgpetclinic.model.Speciality;
import com.sanam.coder.sfgpetclinic.model.Vet;
import com.sanam.coder.sfgpetclinic.services.OwnerService;
import com.sanam.coder.sfgpetclinic.services.PetTypeService;
import com.sanam.coder.sfgpetclinic.services.SpecialityService;
import com.sanam.coder.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialtyService;
	
	
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
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
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Kaleen");
		owner1.setLastName("Bhaiya");
		owner1.setAddress("123 Brickerlane");
		owner1.setCity("Mirzapur");
		owner1.setTelephone("123-456-789");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Guddu");
		owner2.setLastName("Pandit");
		owner2.setAddress("7 Avenue Street");
		owner2.setCity("New york");
		owner2.setTelephone("0111-456-789");
		
		
		Pet gudduPet = new Pet();
		gudduPet.setPetType(savedCatPetType);
		gudduPet.setOwner(owner2);
		gudduPet.setBirthDate(LocalDate.now());
		gudduPet.setName("Tawde");
		owner2.getPets().add(gudduPet);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners..");
		
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Rashid");
		vet1.setLastName("Khan");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Henry");
		vet2.setLastName("Klasen");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
		System.out.println("Loaded Vets..");
	}

}
