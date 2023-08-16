package com.falconSports.entity;



import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AgeGroup {
	
	@Id
	private int ageGroupId;
	private String ageGroupName;

	
	public int getAgeGroupId() {
		return ageGroupId;
	}
	public void setAgeGroupId(int ageGroupId) {
		this.ageGroupId = ageGroupId;
	}
	public String getAgeGroupName() {
		return ageGroupName;
	}
	public void setAgeGroupName(String ageGroupName) {
		this.ageGroupName = ageGroupName;
	}
	public AgeGroup(int ageGroupId, String ageGroupName) {
		super();
		this.ageGroupId = ageGroupId;
		this.ageGroupName = ageGroupName;
	}
	public AgeGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	
	

	

}
