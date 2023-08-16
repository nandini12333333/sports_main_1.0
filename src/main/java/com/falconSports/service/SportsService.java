package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Sports;
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface SportsService {
	
	public List<Sports> getSports() throws ResourceNotFoundException;
	public Sports createSports(Sports sports);
	public Sports getSportsById(int sportsId) throws IdNotFoundException;
	public void deleteSportsById(int sportsId) throws IdNotFoundException;
	public Sports updateSports(int sportsId,Sports sports);
	public List<Sports> getSportsCategory(SportsCategory sportsCategory);

}
