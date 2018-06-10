package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
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
	
	@GetMapping({"/{id}"})
	public String singleProduct(@PathVariable("id") long id, Model model) {
		model.addAttribute("productTypes", ProductType.values());
		model.addAttribute("product", productService.findOne(id));
		return "product";
	}
	
	@DeleteMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		productService.delete(id);
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("productTypes", ProductType.values());
		return "product";
	}
	
	@PostMapping("/")
	public String addNew(@ModelAttribute("Product") Product product) {
		productService.save(product);
		return "redirect:/product/list";
	}
}
