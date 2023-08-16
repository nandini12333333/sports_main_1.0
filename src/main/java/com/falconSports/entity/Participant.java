package com.falconSports.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Participant {
	
	@Id
	private String participantId;
	
	private String participantName;
	
	
	
	@ManyToOne
	@JoinColumn(name= "ageGroupId", referencedColumnName= "ageGroupId")
	private AgeGroup ageGroup;
	
	@ManyToOne(targetEntity = Organization.class)
	@JoinColumn(name= "organizationId", referencedColumnName= "organizationId")
	private Organization organization;
	
	@ManyToOne(targetEntity = Sports.class)
	@JoinColumn(name= "sportsId", referencedColumnName= "sportsId")
	private Sports sports;
	
	private String email;
	


	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}





	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(String participantId, String participantName, AgeGroup ageGroup, Organization organization,
			Sports sports, String email) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.ageGroup = ageGroup;
		this.organization = organization;
		this.sports = sports;
		this.email = email;
		
	}

}
