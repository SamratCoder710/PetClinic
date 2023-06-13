package com.sanam.coder.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sanam.coder.sfgpetclinic.model.Speciality;
import com.sanam.coder.sfgpetclinic.model.Vet;
import com.sanam.coder.sfgpetclinic.services.SpecialityService;
import com.sanam.coder.sfgpetclinic.services.VetService;
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll(){
		return super.findAll();
	}


	@Override
	public Vet save(Vet object) {
		 if (object.getSpecialities().size() > 0){
	            object.getSpecialities().forEach(speciality -> {
	                if(speciality.getId() == null){
	                    Speciality savedSpecialty = specialityService.save(speciality);
	                    speciality.setId(savedSpecialty.getId());
	                }
	            });
	        }

	        return super.save(object);
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
