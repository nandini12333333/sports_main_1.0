package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Winners;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.WinnersRepository;

@Service
public class WinnersServiceImpl implements WinnersService{
	
	
	@Autowired
	private WinnersRepository winnersRepository;

	@Override
	public List<Winners> getWinners() throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		if(winnersRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return winnersRepository.findAll();
	}

	@Override
	public Winners createWinners(Winners winners) {
		// TODO Auto-generated method stub
		return winnersRepository.save(winners);
	}

	@Override
	public Winners getByWinnersYear(int year) {
		// TODO Auto-generated method stub
		return winnersRepository.getByYear(year);
	}

}
