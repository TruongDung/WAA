package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Product;
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
		orderService.test();
		List<Product> ls = productService.getAllProduct();
		//System.out.println(productService.getAllProduct());
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
}
