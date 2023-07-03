package com.sanam.coder.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
