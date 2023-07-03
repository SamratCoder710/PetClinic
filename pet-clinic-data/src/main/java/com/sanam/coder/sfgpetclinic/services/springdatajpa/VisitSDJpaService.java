package com.sanam.coder.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.sanam.coder.sfgpetclinic.model.Visit;
import com.sanam.coder.sfgpetclinic.repositories.VisitRepository;
import com.sanam.coder.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> vets = new HashSet<>();
		visitRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}


}
