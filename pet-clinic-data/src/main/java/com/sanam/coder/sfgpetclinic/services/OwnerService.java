package com.sanam.coder.sfgpetclinic.services;

import java.util.Set;

import com.sanam.coder.sfgpetclinic.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner save(Owner owner);
	
	Owner findById(Long id);
	
	Set<Owner> findAll();

}
