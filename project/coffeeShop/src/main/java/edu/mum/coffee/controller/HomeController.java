package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}

	@GetMapping({"/login"})
	public String securePage() {
		return "login";
	}
	
	@GetMapping("/register") 
	public String register(Model model) {
		model.addAttribute("person", new Person());
		return "register";
	}
	
	@PostMapping("/register")
	public String signup(@ModelAttribute Person person) {
		personService.register(person);
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
