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
import com.falconSports.entity.SportsCategory;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.SportsCategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class SportsCategoryController {
	
	@Autowired
	private SportsCategoryService sportsCategoryService;
	
	@GetMapping("/getSportsCategory")
	public ResponseEntity<List<SportsCategory>> getSportsCategory() throws ResourceNotFoundException
	{
		List<SportsCategory> listSportsCategory = sportsCategoryService.getSportsCategoryList();
		return new ResponseEntity<>(listSportsCategory,HttpStatus.OK);
	}
	
	@PostMapping("/createSportsCategory")
	public ResponseEntity<SportsCategory> createSportsCategory(@RequestBody SportsCategory sportsCategory)
	{
		SportsCategory create = sportsCategoryService.createSportsCategory(sportsCategory);
		return new ResponseEntity<>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/getSportsCategory/{categoryId}")
	public SportsCategory getSportsCategoryById(@PathVariable String categoryId) throws IdNotFoundException
	{
		return sportsCategoryService.getSportsCategoryById(categoryId);
	}
	
	@DeleteMapping("/deleteSportsCategory/{categoryId}")
	public ResponseEntity<String> deleteSportsCategoryById(@PathVariable String categoryId) throws IdNotFoundException
	{
		sportsCategoryService.deleteSportsCategoryById(categoryId);
		return new ResponseEntity<>("deleted Sucessfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateSportsCategory/{categoryId}")
	public SportsCategory updateSportsCategory(@PathVariable String  categoryId, @RequestBody SportsCategory sportsCategory)
	{
		return sportsCategoryService.updateSportsCategory(categoryId, sportsCategory);
	}
	
	
	

}
