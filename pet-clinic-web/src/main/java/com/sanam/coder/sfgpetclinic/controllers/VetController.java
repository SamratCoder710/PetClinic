package com.sanam.coder.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanam.coder.sfgpetclinic.services.VetService;
@RequestMapping("/vets")
@Controller
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"","/","index","index.html"})
	public String index(Model m) {
		m.addAttribute("vets",vetService.findAll());
		return "vets/index";
	}

}
