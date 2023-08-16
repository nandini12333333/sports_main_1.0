package com.falconSports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconSports.entity.Event;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	
	@GetMapping("/getEvent")
	public ResponseEntity<List<Event>> getAllEvent() throws ResourceNotFoundException
	{
		List<Event> getEvent = eventService.getAllEvents();
		return new ResponseEntity<>(getEvent,HttpStatus.OK);
	}
	
	@PostMapping("/createEvent")
	public ResponseEntity<Event> createEvent(@RequestBody Event event)
	{
		Event create = eventService.createEvent(event);
		return new ResponseEntity<>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/getEvent/{eventId}")
	public Event getEventById(@PathVariable int eventId) throws IdNotFoundException
	{
		return eventService.getEventById(eventId);
	}
	
	@DeleteMapping("/deleteEvent")
	public ResponseEntity<String> deleteEvent(@PathVariable int eventId) throws IdNotFoundException
	{
		 eventService.deleteEventById(eventId);
		 return new ResponseEntity<>("deleted Sucessfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateEvent")
	public Event updateEvent(@PathVariable int eventId, @RequestBody Event event)
	{
		return eventService.updateEvent(eventId, event);
	}

}
