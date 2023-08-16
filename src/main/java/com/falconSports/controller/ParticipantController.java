package com.falconSports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconSports.entity.Participant;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.ParticipantService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class ParticipantController {
	
	@Autowired
	private ParticipantService participantService;
	

	
	@GetMapping("/getParticipants")
	public ResponseEntity<List<Participant>> getAllParticipants() throws ResourceNotFoundException
	{
		List<Participant> getParticipant = participantService.getAllParticipant();
		return new ResponseEntity<>(getParticipant,HttpStatus.OK);
	}
	
	@PostMapping("/createParticipant")
	public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant)
	{
        
		Participant create =  participantService.createParticipant(participant);
		return  ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	@GetMapping("/getParticipants/{participantId}")
	public Participant getParticipantById(@PathVariable String participantId) throws IdNotFoundException
	{
		return participantService.getParticipantById(participantId);
	}
	
	@DeleteMapping("/deleteParticipants/{participantId}")
	public ResponseEntity<String> deleteParticipantByid(@PathVariable String participantId) throws IdNotFoundException
	{
		participantService.deleteParticipantById(participantId);
		return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
	}
	
	
	@PutMapping("/updateParticipant/{participantId}")
	public Participant updateParticipant(@PathVariable String participantId , @RequestBody Participant participant)
	{
		return participantService.updateParticipant(participantId, participant);
	}
	
	@GetMapping("/count")
	public int countParticipant()
	{
		return participantService.count();
	}

}
