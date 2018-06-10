package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.ProductService;

@RequestMapping(path="/product")
@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping({"/list"})
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	@DeleteMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		productService.delete(id);
		
	}
	
	@RequestMapping("/add")
	public String add() {
		return "product";
	}
}
