package edu.mum.coffee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.custom.UserDetailsCustom;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@Controller
@RequestMapping(path="person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/list")
	public String personList(Model model, Authentication authentication) {
		model.addAttribute("persons", personService.findAll());
		return "personList";
	}

	@PostMapping("/person")
	public String createPerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Person p = new Person();
		model.addAttribute("person",p );
		return "myInformation";
	}
	
	@GetMapping("/me")
	public String myInformation(Model model, Authentication authentication) {
		UserDetailsCustom u = (UserDetailsCustom) authentication.getPrincipal();
		model.addAttribute("person", this.personService.findById(u.getId()));		
		return "myInformation";
	}
	
	@PostMapping("/myInformation")
	public String myInformationPost(@Valid @ModelAttribute("Person") Person person) {
		Long preId = person.getId();
		personService.savePerson(person);
		if(preId == 0) {
			return "redirect:/person/list";
		}
		return "redirect:/person/me";
	}
}
