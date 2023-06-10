package com.sanam.coder.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanam.coder.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/","index","index.html"})
	public String index(Model m) {
		m.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

}
