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
	
	@GetMapping({"/"})
	public String homePage(Model model) {
		System.out.println(productService.getAllProduct());
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute Person person) {
		personService.signup(person);
		return "redirect:/login";
	}
	
}
