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

import com.falconSports.entity.Fixture;
import com.falconSports.service.FixtureService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class FixtureController {
	
	@Autowired
	private FixtureService fixtureService;
	
	@GetMapping("/getFixture")
	public ResponseEntity<List<Fixture>> getAllFixture()
	{
		List<Fixture> getFixture = fixtureService.getAllFixture();
		return new ResponseEntity<>(getFixture,HttpStatus.OK);
	}
	
	@PostMapping("/createFixture")
	public ResponseEntity<Fixture> createFixture(@RequestBody Fixture fixture)
	{
		Fixture createFixture = fixtureService.createFixture(fixture);
		return new ResponseEntity<>(createFixture,HttpStatus.CREATED);
	}
	
	@GetMapping("/getFixture/{fixtureId}")
	public Fixture getFixturesById(@PathVariable int fixtureId)
	{
		return fixtureService.getByFixtureId(fixtureId);
	}
	
	@DeleteMapping("/deleteFixture/{fixtureId}")
	public ResponseEntity<String> deleteFixture(@PathVariable int fixtureId)
	{
		fixtureService.deleteFixture(fixtureId);
		return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateFixture/{fixtureId}")
	public Fixture updateFixture(@PathVariable int fixtureId, @RequestBody Fixture fixture)
	{
		return fixtureService.updateFixture(fixtureId, fixture);
	}

}
