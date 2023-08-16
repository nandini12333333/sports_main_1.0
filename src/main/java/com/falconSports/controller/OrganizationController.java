package com.falconSports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconSports.entity.Organization;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.OrganizationService;

@CrossOrigin
@RestController
@RequestMapping("api/sports")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService; 
	
	//organization Controller
	
	
		@GetMapping("/getOrganization")
		public ResponseEntity<List<Organization>> getOrganization() throws ResourceNotFoundException
		{
			List<Organization> getAllOrganization = organizationService.getOrganizationList();
			return new ResponseEntity<>(getAllOrganization,HttpStatus.OK);
		}
		
		@PostMapping("/createOrganization")
		public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization)
		{
			Organization createOrganization = organizationService.createOrganization(organization);
			return new ResponseEntity<>(createOrganization,HttpStatus.CREATED);
		}
		
		@GetMapping("/getOrganization/{organizationId}")
		public Organization getOrganizationByid(@PathVariable int organizationId) throws IdNotFoundException
		{
			return organizationService.getOrganizationById(organizationId);
		}
		
		@DeleteMapping("/deleteOrganization/{organizationId}")
		public ResponseEntity<String> deleteOrganizationById(@PathVariable int organizationId) throws IdNotFoundException
		{
			organizationService.deleteOrganizationById(organizationId);
			return new ResponseEntity<>("Deleted SuccessFully",HttpStatus.OK);
		}
		
		@PutMapping("/updateOrganization/{organizationId}")
		public Organization updateOrganization(@PathVariable int organizationId,@RequestBody Organization organization)
		{
			return organizationService.updateOrganization(organizationId, organization);
		}
		
		@GetMapping("/countOrg")
		public int countParticipants()
		{
			return organizationService.countOrganization();
		}
		

}
