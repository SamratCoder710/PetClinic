package com.sanam.coder.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Pet;
import com.sanam.coder.sfgpetclinic.model.PetType;
import com.sanam.coder.sfgpetclinic.model.Vet;
import com.sanam.coder.sfgpetclinic.services.OwnerService;
import com.sanam.coder.sfgpetclinic.services.PetService;
import com.sanam.coder.sfgpetclinic.services.PetTypeService;
import com.sanam.coder.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		
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
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Henry");
		vet2.setLastName("Klasen");
		
		vetService.save(vet2);
		System.out.println("Loaded Vets..");
		
	}

}
