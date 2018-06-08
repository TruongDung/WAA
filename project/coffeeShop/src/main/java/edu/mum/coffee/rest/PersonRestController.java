package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping(path="/api/person")
public class PersonRestController {
	
	@Autowired
	PersonService _personService;
	
	@RequestMapping("/list")
	public List<Person> list(){
		return null;
	}
}
