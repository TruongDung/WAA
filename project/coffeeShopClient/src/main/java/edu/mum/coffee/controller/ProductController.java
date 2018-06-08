package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.service.ProductService;

@RequestMapping(path="/product")
@Controller
public class ProductController {
	
	@GetMapping({"/list"})
	public String list(Model model) {
		
		return "index";
	}
}
