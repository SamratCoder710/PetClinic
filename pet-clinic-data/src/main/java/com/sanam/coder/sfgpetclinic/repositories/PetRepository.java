package com.sanam.coder.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
