package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping(path="/api/product")
public class ProductRestController {
	
	@Autowired
	ProductService _productService;
	
	@RequestMapping("/list")
	public List<?> list() {
		List<Product> list = _productService.getAllProduct();
		return list;
	}
	
	
	
}
