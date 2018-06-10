package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") long id) {
		Product p = _productService.getProduct(id);
		_productService.delete(p);
	}
}
