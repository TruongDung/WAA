package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/"})
	public String homePage(Model model) {
		System.out.println(productService.getAllProduct());
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}
}
