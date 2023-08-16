package com.falconSports.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.falconSports.entity.Team;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;

@Service
public interface TeamService {
	
	public List<Team> getAllTeam() throws ResourceNotFoundException;
	public Team createTeam(Team team);
	public Team getTeamById(int teamId) throws IdNotFoundException;
	public void deleteTeamById(int teamId) throws IdNotFoundException;
	public Team updateTeam(int teamId, Team team);
	
	public List<Team> generateTeams();

}
