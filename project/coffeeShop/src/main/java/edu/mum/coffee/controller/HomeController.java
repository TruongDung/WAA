package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
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
	public String register() {
		return "register";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
