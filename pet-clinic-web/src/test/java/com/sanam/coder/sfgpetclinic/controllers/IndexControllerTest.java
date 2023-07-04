package com.sanam.coder.sfgpetclinic.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class IndexControllerTest {
	
	IndexController indexController;

	@BeforeEach
	public void setUp() throws Exception {
		indexController = new IndexController();
	}

	@Test
	public void testIndex() {
		String viewName = indexController.index();
		assertEquals("index", viewName);
	}

}
