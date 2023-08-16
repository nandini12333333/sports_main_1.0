package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Event;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(eventRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return eventRepository.findAll();
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.save(event);
	}

	@Override
	public Event getEventById(int eventId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if(eventRepository.findById(eventId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Event event = eventRepository.findById(eventId).get();
		return event;
	}

	@Override
	public void deleteEventById(int eventId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		if(eventRepository.findById(eventId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		eventRepository.deleteById(eventId);
		System.out.println("Deleted Successfully");
		
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		// TODO Auto-generated method stub
		event.setEventId(eventId);
		return this.eventRepository.save(event);
	}
	
	

}
