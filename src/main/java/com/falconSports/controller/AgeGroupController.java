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

import com.falconSports.entity.AgeGroup;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.service.AgeGroupService;

@CrossOrigin
@RequestMapping("/api/sports")
@RestController
public class AgeGroupController {
	
	@Autowired
	private AgeGroupService ageGroupService;
	
	@GetMapping("/getAgeGroup")
	public ResponseEntity<List<AgeGroup>> getAgeGroup()
	{
		List<AgeGroup> ageGroup = ageGroupService.getAllAgeGroup();
		return new ResponseEntity<>(ageGroup,HttpStatus.OK);
	}
	
	@PostMapping("/createAgeGroup")
	public ResponseEntity<AgeGroup> createAgeGroup(@RequestBody AgeGroup ageGroup)
	{
		AgeGroup create = ageGroupService.createAgeGroup(ageGroup);
		return new ResponseEntity<>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAgeGroup/{ageGroupId}")
	public AgeGroup getAgeGroupById(@PathVariable int ageGroupId) throws IdNotFoundException
	{
		return ageGroupService.getAgeGroupById(ageGroupId);
	}
	
	@DeleteMapping("/deleteAgeGroup/{ageGroupId}")
	public ResponseEntity<String> deleteAgeGroupId(@PathVariable int ageGroupId)
	{
		ageGroupService.deleteByAgeGroupId(ageGroupId);
		return new ResponseEntity<>("Deleted Sucessfully id is : "+ageGroupId+"",HttpStatus.OK);
	}
	
	@PutMapping("/updateAgeGroup/{ageGrouId}")
	public AgeGroup updateAgeGroup(@PathVariable int ageGroupId, @RequestBody AgeGroup ageGroup)
	{

		return ageGroupService.updateAgeGroup(ageGroupId, ageGroup);
	}

}
