package com.sanam.coder.sfgpetclinic.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanam.coder.sfgpetclinic.model.Pet;


public class IndexControllerTest {
	
	IndexController indexController;

	@Before
	public void setUp() throws Exception {
		indexController = new IndexController();
	}

	@Test
	public void testIndex() {
		String viewName = indexController.index();
		assertEquals("index", viewName);
	}

}
