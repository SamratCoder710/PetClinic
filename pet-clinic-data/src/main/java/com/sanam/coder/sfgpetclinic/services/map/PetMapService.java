package com.sanam.coder.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sanam.coder.sfgpetclinic.model.Pet;
import com.sanam.coder.sfgpetclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll(){
		return super.findAll();
	}
	
	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
