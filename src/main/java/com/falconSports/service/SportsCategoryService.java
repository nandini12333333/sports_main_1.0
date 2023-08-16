package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Organization;
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service

public interface SportsCategoryService {
	
	public List<SportsCategory> getSportsCategoryList() throws ResourceNotFoundException;
	public SportsCategory createSportsCategory(SportsCategory sportsCategory);
	public SportsCategory getSportsCategoryById(String categoryId) throws IdNotFoundException;
	public void deleteSportsCategoryById(String categoryId) throws IdNotFoundException;
	public SportsCategory updateSportsCategory(String sportsCategoryId, SportsCategory sportsCategory);

}
