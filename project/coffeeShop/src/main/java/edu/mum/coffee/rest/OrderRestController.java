package edu.mum.coffee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController
@RequestMapping(path="/api/order")
public class OrderRestController {
	
	@Autowired
	OrderService orderService;

	
	@RequestMapping(value="/test")
	public String test() {
		return "Test String";
	}
	
	@RequestMapping("/list")
	public List<Order> list(){
		List<Order> orders = orderService.findAll();
		return orders;
	}
	
}
