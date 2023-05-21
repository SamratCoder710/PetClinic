package com.sanam.coder.sfgpetclinic.services;

import java.util.Set;

import com.sanam.coder.sfgpetclinic.model.Vet;


public interface VetService {
	
	Vet save(Vet owner);
	
	Vet findById(Long id);
	
	Set<Vet> findAll();

}
