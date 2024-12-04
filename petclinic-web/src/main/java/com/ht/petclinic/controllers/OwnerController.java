package com.ht.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.petclinic.services.OwnerService;

@Controller
@RequestMapping("owners/find")
public class OwnerController {
	
	private OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@GetMapping({"", "/"})
	public String owners(Model model) {
		System.out.println("Returning owners list page");
		
		model.addAttribute("owners", ownerService.findAll());
		
		return "/owners/index";
	}
}
