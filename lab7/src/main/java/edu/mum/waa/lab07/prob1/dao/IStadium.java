package edu.mum.waa.lab07.prob1.dao;

import java.util.List;

import edu.mum.waa.lab07.prob1.entities.Stadium;

public interface IStadium {
	public abstract List<Stadium> getAll();
	public abstract void add(Stadium st);
	public abstract Stadium get(int id);
	public abstract void update(int id, Stadium st);
	void delete(int id);
}
