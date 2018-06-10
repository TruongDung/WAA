package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping(path="/api/person")
public class PersonRestController {
	
	@Autowired
	PersonService _personService;
	
	@RequestMapping("/list")
	public List<Person> list(){
		return _personService.findAll();
	}
	
	@PostMapping(value="/create")
	public void Save(@RequestBody Person person) {
		_personService.savePerson(person);
	}
}
