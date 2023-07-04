package com.sanam.coder.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
	
	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().firstName("Golu").lastName("Singh").build();
		returnOwner.setId(1l);
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner owner = service.save(returnOwner);
		assertNotNull(owner);
		assertEquals(1, owner.getId());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner ownerById = service.findById(1L);
		assertNotNull(ownerById);
		assertEquals(1, ownerById.getId());
		verify(ownerRepository).findById(anyLong());
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().firstName("Venky").build());
		returnOwnerSet.add(Owner.builder().firstName("Keshav").build());
		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		Set<Owner> ownerAll = service.findAll();
		assertEquals(2, ownerAll.size());
		verify(ownerRepository).findAll();
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(anyString())).thenReturn(returnOwner);
		Owner ownerByLastName = service.findByLastName("Singh");
		assertNotNull(ownerByLastName);
		assertEquals(1, ownerByLastName.getId());
	}

}
