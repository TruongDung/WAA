package edu.mum.coffee.service;

import java.util.Arrays;
import java.util.List;

import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.config.RestHttpHeader;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;

@Service
public class PersonService {
	@Autowired
	RestHttpHeader restHttpHeader;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public Person savePerson(Person person) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		HttpEntity<Person> httpEntity = new HttpEntity<Person>(person, restHttpHeader.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/api/person/create", httpEntity, Product.class);
		return null;
	}

	public List<Person> findAll() {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/api/person/list", HttpMethod.GET, restHttpHeader.getHttpEntity(), Person[].class).getBody());
	}
	
}
