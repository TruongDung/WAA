package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.service.OrderService;

@Controller
@RequestMapping(path="/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/list")
	public String getList(Model model){
		model.addAttribute("orders", orderService.findAll());
		return "orderList";
	}
}
