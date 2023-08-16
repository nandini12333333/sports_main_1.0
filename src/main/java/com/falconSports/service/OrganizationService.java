package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Organization;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface OrganizationService {

	public List<Organization> getOrganizationList() throws ResourceNotFoundException;
	public Organization createOrganization(Organization organization);
	public Organization getOrganizationById(int organizationId) throws IdNotFoundException;
	public void deleteOrganizationById(int organizationId)throws IdNotFoundException;
	public Organization updateOrganization(int organizationId, Organization organization);
	public int countOrganization();

}
