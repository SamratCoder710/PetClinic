package com.sanam.coder.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.model.Pet;
import com.sanam.coder.sfgpetclinic.services.OwnerService;
import com.sanam.coder.sfgpetclinic.services.PetService;
import com.sanam.coder.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll(){
		return super.findAll();
	}
	
	@Override
	public Owner save(Owner object) {
		 if(object != null){
	            if (object.getPets() != null) {
	                object.getPets().forEach(pet -> {
	                    if (pet.getPetType() != null){
	                        if(pet.getPetType().getId() == null){
	                            pet.setPetType(petTypeService.save(pet.getPetType()));
	                        }
	                    } else {
	                        throw new RuntimeException("Pet Type is required");
	                    }

	                    if(pet.getId() == null){
	                        Pet savedPet = petService.save(pet);
	                        pet.setId(savedPet.getId());
	                    }
	                });
	            }

	            return super.save(object);

	        } else {
	            return null;
	        }
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
	}

}
