package edu.mum.waa.lab07.prob1.dao;

import java.util.List;

import edu.mum.waa.lab07.prob1.entities.Team;

public interface ITeam {
	public abstract List<Team> getAll();
	public abstract void add(Team st);
	public abstract Team get(int id);
	public abstract void update(int id, Team st);
	void delete(int id);
}
