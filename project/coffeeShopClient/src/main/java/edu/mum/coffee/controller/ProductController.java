package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping({"/product"})
	public String homePage(Model model) {
		System.out.println("product");
		return "index";
	}
}
