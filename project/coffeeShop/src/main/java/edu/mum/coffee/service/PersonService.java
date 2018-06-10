package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.PersonRepository;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private UserRepository userRepository;

	public Person savePerson(Person person) {
		User user = userRepository.findByEmail(person.getEmail());
		if(user!=null) {
			user.setEnabled(person.isEnable());
			userRepository.save(user);
		}
		return personRepository.save(person);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}

}
