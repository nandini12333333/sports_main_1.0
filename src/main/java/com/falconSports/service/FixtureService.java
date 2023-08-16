package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Fixture;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface FixtureService {
	
	public List<Fixture> getAllFixture() throws ResourceNotFoundException;
	public Fixture createFixture(Fixture fixture);
	public Fixture getByFixtureId(int fixtureId) throws IdNotFoundException;
	public void deleteFixture(int fixtureId)throws IdNotFoundException;
	public Fixture updateFixture(int fixtureId, Fixture fixture);


}
