package edu.mum.coffee.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping(path="/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	public String products(Model model) {		
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
}
