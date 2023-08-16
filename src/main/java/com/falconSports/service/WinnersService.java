package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Winners;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface WinnersService {
	
	public List<Winners> getWinners() throws ResourceNotFoundException;
	public Winners createWinners(Winners winners);
	public Winners getByWinnersYear(int year);

}
