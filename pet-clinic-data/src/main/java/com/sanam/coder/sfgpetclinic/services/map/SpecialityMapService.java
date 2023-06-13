package com.sanam.coder.sfgpetclinic.services.map;

import java.util.Set;

import com.sanam.coder.sfgpetclinic.model.Speciality;
import com.sanam.coder.sfgpetclinic.services.SpecialityService;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService  {

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

}