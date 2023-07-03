package com.sanam.coder.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sanam.coder.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);

}
