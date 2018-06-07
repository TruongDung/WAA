package edu.mum.waa.lab07.prob1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.waa.lab07.prob1.services.TeamService;

@Controller()
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
}
