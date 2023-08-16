package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.AgeGroup;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface AgeGroupService {
	
	public List<AgeGroup> getAllAgeGroup() throws ResourceNotFoundException;
	public AgeGroup createAgeGroup(AgeGroup ageGroup);
	public AgeGroup getAgeGroupById(int ageGroupId) throws IdNotFoundException;
	public void deleteByAgeGroupId(int ageGroupId) throws IdNotFoundException;
	public AgeGroup updateAgeGroup(int ageGroupId, AgeGroup ageGroup) throws IdNotFoundException;
	

}
