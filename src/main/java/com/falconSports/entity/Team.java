package com.falconSports.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int teamId;
	private String teamName;
	
	
	@OneToOne(targetEntity = Sports.class)
	@JoinColumn(name= "sportsId", referencedColumnName= "sportsId")
	private Sports sports;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="participant_id", referencedColumnName="participant_id")
    private List<Participant> participants;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public List<Participant> getParticipant() {
		return participants;
	}

	public void setParticipant(List<Participant> participants) {
		this.participants = participants;
	}

	public Team() {
		super();
		participants = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Team(int teamId, String teamName, Sports sports, List<Participant> participant) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.sports = sports;
		this.participants = participant;
	}
	

	
}
