package com.falconSports.entity;

import java.time.LocalDateTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Fixture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int fixtureId;
	
	
	@OneToOne(targetEntity = Event.class)
	@JoinColumn(name= "eventId", referencedColumnName= "eventId")
	private Event event;
	
	@OneToOne(targetEntity = Sports.class)
	@JoinColumn(name= "sportsId", referencedColumnName= "sportsId")
	private Sports sports;
	
	@OneToOne(targetEntity = Team.class)
	@JoinColumn(name= "team1", referencedColumnName= "teamId")
	private Team team1Id;
	
	@OneToOne(targetEntity = Team.class)
	@JoinColumn(name= "team2", referencedColumnName= "teamId")
	private Team team2Id;
	
	private String venue;
	
	private LocalDateTime dateTime;

	public int getFixtureId() {
		return fixtureId;
	}

	public void setFixtureId(int fixtureId) {
		this.fixtureId = fixtureId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public Team getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(Team team1Id) {
		this.team1Id = team1Id;
	}

	public Team getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(Team team2Id) {
		this.team2Id = team2Id;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Fixture(int fixtureId, Event event, Sports sports, Team team1Id, Team team2Id, String venue,
			LocalDateTime dateTime) {
		super();
		this.fixtureId = fixtureId;
		this.event = event;
		this.sports = sports;
		this.team1Id = team1Id;
		this.team2Id = team2Id;
		this.venue = venue;
		this.dateTime = dateTime;
	}

	public Fixture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
