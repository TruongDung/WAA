package edu.mum.waa.lab07.prob1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.waa.lab07.prob1.entities.Team;

public class TeamDao implements ITeam {

	private static int idCount = 1;
	private Map<Integer, Team> teams = new HashMap<>();
	
	public TeamDao() {
		add(new Team());
	}
	
	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Team>(this.teams.values());
	}

	@Override
	public void add(Team st) {
		// TODO Auto-generated method stub
		st.setTeamKey(idCount);
		teams.put(idCount, st);
		idCount++;
	}

	@Override
	public Team get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int id, Team st) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
