package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.AgeGroup;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.AgeGroupRepository;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {
	
	@Autowired
	private AgeGroupRepository ageGroupRepository;

	@Override
	public List<AgeGroup> getAllAgeGroup() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(ageGroupRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return ageGroupRepository.findAll();
	}

	@Override
	public AgeGroup createAgeGroup(AgeGroup ageGroup) {
		// TODO Auto-generated method stub
		return ageGroupRepository.save(ageGroup);
	}

	@Override
	public AgeGroup getAgeGroupById(int ageGroupId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(ageGroupRepository.findById(ageGroupId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		AgeGroup ageGroup = ageGroupRepository.findById(ageGroupId).get();
		return ageGroup;
	}

	@Override
	public void deleteByAgeGroupId(int ageGroupId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(ageGroupRepository.findById(ageGroupId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		ageGroupRepository.deleteById(ageGroupId);
		
	}

	@Override
	public AgeGroup updateAgeGroup(int ageGroupId, AgeGroup ageGroup) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if(ageGroupRepository.findById(ageGroupId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		ageGroup.setAgeGroupId(ageGroupId);
		return ageGroupRepository.save(ageGroup);
	}

}
