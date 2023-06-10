package com.sanam.coder.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Vet;
import com.sanam.coder.sfgpetclinic.services.OwnerService;
import com.sanam.coder.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Rinku");
		owner1.setLastName("Singh");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Sandeep");
		owner2.setLastName("Singh");
		
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
