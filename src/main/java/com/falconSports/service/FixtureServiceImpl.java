package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Fixture;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.FixtureRepository;

@Service
public class FixtureServiceImpl implements FixtureService {
	
	@Autowired
	private FixtureRepository fixtureRepository;

	@Override
	public List<Fixture> getAllFixture()throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(fixtureRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return fixtureRepository.findAll();
	}

	@Override
	public Fixture createFixture(Fixture fixture) {
		// TODO Auto-generated method stub
		return fixtureRepository.save(fixture);
	}

	@Override
	public Fixture getByFixtureId(int fixtureId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if(fixtureRepository.findById(fixtureId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Fixture fixture = fixtureRepository.findById(fixtureId).get();
		return fixture;
	}

	@Override
	public void deleteFixture(int fixtureId)throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(fixtureRepository.findById(fixtureId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		fixtureRepository.deleteById(fixtureId);
		
	}

	@Override
	public Fixture updateFixture(int fixtureId, Fixture fixture) {
		// TODO Auto-generated method stub
		fixture.setFixtureId(fixtureId);
		return this.fixtureRepository.save(fixture);
	}
	
	

}
