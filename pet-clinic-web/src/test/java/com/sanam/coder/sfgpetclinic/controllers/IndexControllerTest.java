package com.sanam.coder.sfgpetclinic.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.sanam.coder.sfgpetclinic.controllers.IndexController;


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
