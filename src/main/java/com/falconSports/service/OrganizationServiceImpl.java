package com.falconSports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Organization;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	
	//Organization Services
	
	@Override
	public List<Organization> getOrganizationList() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(organizationRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return organizationRepository.findAll();
	}

	@Override
	public Organization createOrganization(Organization organization) {
		// TODO Auto-generated method stub
		
		return organizationRepository.save(organization);
	}

	@Override
	public Organization getOrganizationById(int organizationId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		if(organizationRepository.findById(organizationId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Organization organization = organizationRepository.findById(organizationId).get();
		return organization;
	}

	@Override
	public void deleteOrganizationById(int organizationId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(organizationRepository.findById(organizationId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		organizationRepository.deleteById(organizationId);
		
	}

	@Override
	public Organization updateOrganization(int organizationId, Organization organization) {
		// TODO Auto-generated method stub
		organization.setOrganizationId(organizationId);
		return this.organizationRepository.save(organization);
	}

	@Override
	public int countOrganization() {
		// TODO Auto-generated method stub
		return (int) organizationRepository.count();
	}
	
	

}
