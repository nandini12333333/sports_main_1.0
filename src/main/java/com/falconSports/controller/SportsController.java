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

import com.falconSports.entity.Sports;
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.SportsService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class SportsController {
	
	@Autowired
	private SportsService sportsService;
	
	@GetMapping("/getSports")
	public ResponseEntity<List<Sports>> getSports() throws ResourceNotFoundException {
		
		List<Sports> getAllSports = sportsService.getSports();
		return new ResponseEntity<>(getAllSports,HttpStatus.OK);
	}
	
	@GetMapping("/getSports/{sportsId}")
	public Sports getSportsById(@PathVariable int sportsId) throws IdNotFoundException
	{
		return sportsService.getSportsById(sportsId);
	}
	
	@PostMapping("/createSports")
	public ResponseEntity<Sports> createSports(@RequestBody Sports sports)
	{
		Sports create = sportsService.createSports(sports);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{categoryId}")
	public List<Sports> getSportsCategory(@PathVariable String categoryId)
	{
		SportsCategory sportsCategory = new SportsCategory();
		sportsCategory.setCategoryId(categoryId);
		return sportsService.getSportsCategory(sportsCategory);
	}

	@DeleteMapping("/deleteSports/{sportsId}")
	public ResponseEntity<String> deleteSportsById(@PathVariable int sportsId) throws IdNotFoundException
	{
		sportsService.deleteSportsById(sportsId);
		return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
	}
	
	@PutMapping("/updateSports/{sportsId}")
	public Sports updateSports(@PathVariable int sportsId, @RequestBody Sports sports)
	{
		return sportsService.updateSports(sportsId, sports);
	}
	
	

}
