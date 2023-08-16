package com.falconSports.entity;

import java.time.LocalDateTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Event {
	
	@Id
	private int eventId;
	private String eventName;
	
	@OneToOne(targetEntity = SportsCategory.class)
	@JoinColumn(name= "categoryId", referencedColumnName= "categoryId")
	private SportsCategory sportsCategory;
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public SportsCategory getSportsCategory() {
		return sportsCategory;
	}
	public void setSportsCategory(SportsCategory sportsCategory) {
		this.sportsCategory = sportsCategory;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Event(int eventId, String eventName, SportsCategory sportsCategory, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.sportsCategory = sportsCategory;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
