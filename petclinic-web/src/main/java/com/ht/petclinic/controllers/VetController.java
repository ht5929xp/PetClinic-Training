package com.ht.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.petclinic.services.VetService;

@Controller
@RequestMapping("vets/find")
public class VetController {

	private VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@GetMapping({"", "/"})
	public String owners(Model model) {
		System.out.println("Returning vets list page");
		
		model.addAttribute("vets", vetService.findAll());
		
		return "/vets/index";
	}
}
