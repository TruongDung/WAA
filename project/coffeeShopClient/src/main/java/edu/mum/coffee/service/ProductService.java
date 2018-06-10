package edu.mum.coffee.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.config.RestHttpHeader;
import edu.mum.coffee.domain.Product;


@Service
@Transactional
public class ProductService   {
	
	@Autowired
	RestHttpHeader restHttpHeader;
	
	public List<Product> getAllProduct() {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/api/product/list", HttpMethod.GET, restHttpHeader.getHttpEntity(), Product[].class).getBody());
		//return Arrays.asList(restTemplate.exchange("http://localhost:8080/api/entries/", HttpMethod.GET, restHttpHeader.getHttpEntity(), Entry[].class).getBody());
	}
}
