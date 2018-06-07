package edu.mum.waa.lab07.prob1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.mum.waa.lab07.prob1.entities.Match;

@Service
public class MatchService {
	private int countId = 1;
	private Map<Integer, Match> matches = new HashMap<>();
	
	public void add(Match m) {
		//m.setMatchKey(countId);
		matches.put(countId, m);
		countId++;
	}
}
