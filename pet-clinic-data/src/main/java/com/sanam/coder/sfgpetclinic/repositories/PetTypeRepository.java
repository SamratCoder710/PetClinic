package com.sanam.coder.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
