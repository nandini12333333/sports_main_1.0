package com.falconSports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falconSports.entity.Winners;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.WinnersService;

@RestController
@CrossOrigin
@RequestMapping("/api/sports")
public class WinnersController {
	
	@Autowired
	private WinnersService winnersService;
	
	
	@GetMapping("/getWinners")
	public ResponseEntity<List<Winners>> getAllWinners() throws ResourceNotFoundException
	{
		List<Winners> getWinners = winnersService.getWinners();
		return new ResponseEntity<>(getWinners, HttpStatus.OK);
	}
	
	
	@PostMapping("/createWinners")
	public ResponseEntity<Winners> createWinners(@RequestBody Winners winners)
	{
		Winners create = winnersService.createWinners(winners);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
	}
	
	@GetMapping("/getWinners/{year}")
	public ResponseEntity<Winners> getwinnersByYear(@PathVariable int year)
	{
		Winners getWinnerYear =  winnersService.getByWinnersYear(year);
		return new ResponseEntity<>(getWinnerYear, HttpStatus.OK);
	}

}
