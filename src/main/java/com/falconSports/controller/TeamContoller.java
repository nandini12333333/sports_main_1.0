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

import com.falconSports.entity.Team;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.service.TeamService;

@CrossOrigin
@RestController
@RequestMapping("/api/sports")
public class TeamContoller {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/getTeam")
	public ResponseEntity<List<Team>>getAllTeam() throws ResourceNotFoundException {
		List<Team> getTeam= teamService.getAllTeam();
		return new ResponseEntity<>(getTeam, HttpStatus.OK);
	}

	@GetMapping("/getTeam/{teamId}")
	public Team getTeamById(@PathVariable int teamId) throws IdNotFoundException
	{
		return teamService.getTeamById(teamId);
	}
	
	@PostMapping("/createTeam")
	public ResponseEntity<Team> createTeam(@RequestBody Team team)
	{
		Team create = teamService.createTeam(team);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteTeam/{teamId}")
	public ResponseEntity<String> deleteTeamById(@PathVariable int teamId) throws IdNotFoundException
	{
		 teamService.deleteTeamById(teamId);
		 return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
	}
	
	@PutMapping("/updateTeam/{teamId}")
	public Team updateTeam(@PathVariable int teamId,@RequestBody Team team)
	{
		return teamService.updateTeam(teamId, team);
	}
	
	@PostMapping("/generateTeam")
	public List<Team> generateAndSaveTeam()
	{
		return teamService.generateTeams();
	}
}
