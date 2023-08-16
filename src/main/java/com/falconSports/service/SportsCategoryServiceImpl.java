package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Organization;
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.OrganizationRepository;
import com.falconSports.repository.SportsCategoryRepository;

@Service
public class SportsCategoryServiceImpl implements SportsCategoryService {
	
	
	@Autowired
	private SportsCategoryRepository  sportsCategoryRepository;

	
	
	@Override
	public List<SportsCategory> getSportsCategoryList() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(sportsCategoryRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return sportsCategoryRepository.findAll();
	}

	@Override
	public SportsCategory createSportsCategory(SportsCategory sportsCategory) {
		// TODO Auto-generated method stub
		return sportsCategoryRepository.save(sportsCategory);
	}


	@Override
	public void deleteSportsCategoryById(String categoryId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(sportsCategoryRepository.findById(categoryId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		sportsCategoryRepository.deleteById(categoryId);
		
	}

	@Override
	public SportsCategory getSportsCategoryById(String categoryId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		
		if(sportsCategoryRepository.findById(categoryId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		SportsCategory sportsCategory = sportsCategoryRepository.findById(categoryId).get();
		return sportsCategory;
	}

	@Override
	public SportsCategory updateSportsCategory(String sportsCategoryId, SportsCategory sportsCategory) {
		// TODO Auto-generated method stub
		sportsCategory.setCategoryId(sportsCategoryId);
		return this.sportsCategoryRepository.save(sportsCategory);
	}

	

}
