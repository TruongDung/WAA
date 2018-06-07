package edu.mum.waa.lab07.prob1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.waa.lab07.prob1.entities.Match;
import edu.mum.waa.lab07.prob1.services.MatchService;

@Controller()
@RequestMapping("/match")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@RequestMapping("/create")
	public String Create() {
		return "match/create";
	}
	
	@RequestMapping(value= {"/create"}, method=RequestMethod.POST)
	public String create(@ModelAttribute("match") Match match) {
		System.out.println("da vao day");
		//matchService.add(match);
		return "match/create";
	}
}
