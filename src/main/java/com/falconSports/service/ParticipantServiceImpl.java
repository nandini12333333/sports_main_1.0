package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Participant;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.ParticipantRepository;

@Service 
public class ParticipantServiceImpl implements ParticipantService{
	
	@Autowired
	private ParticipantRepository participantRepository;
	
//    @Autowired
//    private EmailService emailService;

	@Override
	public List<Participant> getAllParticipant() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if( participantRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return participantRepository.findAll();
	}

	@Override
	public Participant createParticipant(Participant participant) {
		// TODO Auto-generated method stub
		//emailService.sendRegistrationConfirmation(participant);
		return participantRepository.save(participant);
		
	}

	@Override
	public Participant getParticipantById(String participantId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		
		if(participantRepository.findById(participantId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Participant participant = participantRepository.findById(participantId).get();
		return participant;
	}

	@Override
	public void deleteParticipantById(String participantId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(participantRepository.findById(participantId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		participantRepository.deleteById(participantId);
		
	}

	@Override
	public Participant updateParticipant(String participantId,Participant participant) {
		// TODO Auto-generated method stub
		participant.setParticipantId(participantId);
		return this.participantRepository.save(participant);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return (int) participantRepository.count();
	}

}
