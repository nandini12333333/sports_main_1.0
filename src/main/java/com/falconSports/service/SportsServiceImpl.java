package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Sports;
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.SportsRepository;

@Service
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private SportsRepository sportsRepository;

	@Override
	public List<Sports> getSports() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(sportsRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return sportsRepository.findAll();
	}

	@Override
	public Sports createSports(Sports sports) {
		// TODO Auto-generated method stub
		return sportsRepository.save(sports);
	}

	@Override
	public Sports getSportsById(int sportsId)throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(sportsRepository.findById(sportsId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Sports sports  = sportsRepository.findById(sportsId).get();
		return sports;
	}

	@Override
	public void deleteSportsById(int sportsId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(sportsRepository.findById(sportsId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		sportsRepository.deleteById(sportsId);
		
	}

	@Override
	public Sports updateSports(int sportsId, Sports sports) {
		// TODO Auto-generated method stub
		sports.setSportsId(sportsId);
		return this.sportsRepository.save(sports);
	}

	@Override
	public List<Sports> getSportsCategory(SportsCategory sportsCategory) {
		// TODO Auto-generated method stub
		return sportsRepository.findBySportsCategory(sportsCategory);
	}
	
	

}
