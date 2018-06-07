package edu.mum.waa.lab07.prob1.entities;

import java.util.List;

public class Team {
	 
	 /**
	 * @return the teamKey
	 */
	public int getTeamKey() {
		return teamKey;
	}
	/**
	 * @param teamKey the teamKey to set
	 */
	public void setTeamKey(int teamKey) {
		this.teamKey = teamKey;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the mascot
	 */
	public String getMascot() {
		return mascot;
	}
	/**
	 * @param mascot the mascot to set
	 */
	public void setMascot(String mascot) {
		this.mascot = mascot;
	}
	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	/**
	 * @return the homeUniform
	 */
	public String getHomeUniform() {
		return homeUniform;
	}
	/**
	 * @param homeUniform the homeUniform to set
	 */
	public void setHomeUniform(String homeUniform) {
		this.homeUniform = homeUniform;
	}
	/**
	 * @return the visitUniform
	 */
	public String getVisitUniform() {
		return visitUniform;
	}
	/**
	 * @param visitUniform the visitUniform to set
	 */
	public void setVisitUniform(String visitUniform) {
		this.visitUniform = visitUniform;
	}
	/**
	 * @return the matchesAsHome
	 */
	public List<Match> getMatchesAsHome() {
		return matchesAsHome;
	}
	/**
	 * @param matchesAsHome the matchesAsHome to set
	 */
	public void setMatchesAsHome(List<Match> matchesAsHome) {
		this.matchesAsHome = matchesAsHome;
	}
	/**
	 * @return the matchesAsVisitor
	 */
	public List<Match> getMatchesAsVisitor() {
		return matchesAsVisitor;
	}
	/**
	 * @param matchesAsVisitor the matchesAsVisitor to set
	 */
	public void setMatchesAsVisitor(List<Match> matchesAsVisitor) {
		this.matchesAsVisitor = matchesAsVisitor;
	}
	
	private int teamKey;
	private String name;
	 private String city;
	 private String mascot;
	 private List<Player> players;
	 private String homeUniform;
	 private String visitUniform;
	 private List<Match> matchesAsHome;
	 private List<Match> matchesAsVisitor;

	 
	 
}
