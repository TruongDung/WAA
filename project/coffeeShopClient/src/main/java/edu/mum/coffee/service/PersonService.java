package edu.mum.coffee.service;

import java.util.List;

import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;

@Service
public class PersonService {

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public Person savePerson(Person person) {
		return null;
	}

	public List<Person> findAll() {
		return null;
	}
	
}
