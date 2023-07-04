package com.sanam.coder.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sanam.coder.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;

	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		Owner owner = Owner.builder().firstName("Sanam").lastName("Puri").build();
		owner.setId(1L);
		ownerMapService.save(owner);
		
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testSaveOwner() {
		ownerMapService.save(Owner.builder().firstName("Samar").lastName("Puri").build());
		assertEquals(2, ownerMapService.findAll().size());
	}

	@Test
	void testFindByIdLong() {
		Long Id = 1L;
		Owner ownerById = ownerMapService.findById(Id);
		assertEquals(Id, ownerById.getId());
		
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(1L);
		assertEquals(0,ownerMapService.findAll().size() );
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(1L));
		assertEquals(0,ownerMapService.findAll().size() );
	}

	@Test
	void testFindByLastName() {
		Owner ownerByLastName = ownerMapService.findByLastName("Puri");
		assertEquals("Sanam",ownerByLastName.getFirstName());
	}

}
