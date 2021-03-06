package edu.mum.coffee.service;

import edu.mum.coffee.custom.UserDetailsCustom;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PersonService personService;

	public UserService() {
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User With %s doesn't exist!", email));
		}
		List<Person> persons = personService.findByEmail(user.getEmail());
		return new UserDetailsCustom(user, persons.get(0));
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
