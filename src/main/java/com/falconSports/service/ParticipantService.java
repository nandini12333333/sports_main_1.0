package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Participant;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface ParticipantService {
	
	public List<Participant> getAllParticipant() throws ResourceNotFoundException;
	public Participant createParticipant(Participant participant);
	public Participant getParticipantById(String participantId) throws IdNotFoundException;
	public void deleteParticipantById(String participantId) throws IdNotFoundException;
	public Participant updateParticipant(String participantId,Participant participant);
	public int count();

}
