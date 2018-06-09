package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.custom.UserDetailsCustom;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public String personList(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "personList";
	}

	@PostMapping("/person")
	public String createPerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}
	
	@GetMapping("/myInformation")
	public String myInformation(Model model, Authentication authentication) {
		UserDetailsCustom u = (UserDetailsCustom) authentication.getPrincipal();
		//authentication.getPrincipal().getUser();
		System.out.println(u.getId());
		model.addAttribute("person", this.personService.findById(u.getId()));
		return "myInformation";
	}
}
