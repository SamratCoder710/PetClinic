package com.sanam.coder.sfgpetclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sanam.coder.sfgpetclinic.model.Owner;
import com.sanam.coder.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController controller;
	
	MockMvc mockMvc;
	
	Set<Owner> owners;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		Owner owner1 = Owner.builder().build();
		owner1.setId(1L);
        owners.add(owner1);
        Owner owner2 = Owner.builder().build();
		owner1.setId(2L);
        owners.add(owner2);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/index"))
		.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void testError() throws Exception {
		mockMvc.perform(get("/owners/find"))
		.andExpect(status().isOk())
		.andExpect(view().name("notFound"));
		
		verifyNoInteractions(ownerService);
	}

}
