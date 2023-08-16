package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Event;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface EventService {
	
	public List<Event> getAllEvents() throws ResourceNotFoundException;
	public Event createEvent(Event event);
	public Event getEventById(int eventId) throws IdNotFoundException;
	public void deleteEventById(int eventId) throws IdNotFoundException;
	public Event updateEvent(int eventId,Event event);
	

}
