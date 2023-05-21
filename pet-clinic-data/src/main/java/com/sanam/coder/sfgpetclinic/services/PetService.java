package com.sanam.coder.sfgpetclinic.services;

import java.util.Set;

import com.sanam.coder.sfgpetclinic.model.Pet;


public interface PetService {
	
	Pet save(Pet owner);
	
	Pet findById(Long id);
	
	Set<Pet> findAll();

}
