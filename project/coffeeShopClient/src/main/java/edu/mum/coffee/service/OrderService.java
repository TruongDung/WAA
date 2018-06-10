package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.config.RestHttpHeader;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Product;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	RestHttpHeader restHttpHeader;

	public List<Order> findAll(){
		return null;
	}
	
	public String test() {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		String aaa = restTemplate.exchange("http://localhost:8080/api/order/test", HttpMethod.GET, restHttpHeader.getHttpEntity(), String.class).getBody();
	 	return aaa;
	}
}
