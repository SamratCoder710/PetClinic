package com.sanam.coder.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sanam.coder.sfgpetclinic.model.PetType;
import com.sanam.coder.sfgpetclinic.repositories.PetTypeRepository;
import com.sanam.coder.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;
	
	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}


}
