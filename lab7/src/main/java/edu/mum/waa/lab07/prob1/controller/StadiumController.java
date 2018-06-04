package edu.mum.waa.lab07.prob1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StadiumController {
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
