package edu.mum.coffee.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/order")
public class OrderRestController {
	
	@RequestMapping(value="/test")
	public String test() {
		return "Test String";
	}
	
}
