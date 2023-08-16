package com.falconSports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Organization {
	
	@Id
	private int organizationId;
	private String organizationName;
	private int averageStudentStrength;
	
	
	public int getAverageStudentStrength() {
		return averageStudentStrength;
	}
	public void setAverageStudentStrength(int averageStudentStrength) {
		this.averageStudentStrength = averageStudentStrength;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public Organization(int organizationId, String organizationName, int averageStudentStrength) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.averageStudentStrength = averageStudentStrength;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
