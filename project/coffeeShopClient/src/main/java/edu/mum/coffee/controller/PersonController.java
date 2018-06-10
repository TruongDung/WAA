package edu.mum.coffee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RequestMapping(path="/person")
@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/list")
	public String personList(Model model) {
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
	
	@GetMapping("/{id}")
	public String updatePerson(@PathVariable("id") long id, Model model) {
		model.addAttribute("person",personService.findAll().stream().filter(f->f.getId()==id).findFirst());
		return "myInformation";
	}
	
	@PostMapping("/myInformation")
	public String myInformationPost(@Valid @ModelAttribute("Person") Person person) {
		Long preId = person.getId();
		personService.savePerson(person);
		return "redirect:/person/list";
	}
}
