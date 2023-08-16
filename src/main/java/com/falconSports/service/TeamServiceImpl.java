package com.falconSports.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falconSports.entity.Fixture;
import com.falconSports.entity.Organization;
import com.falconSports.entity.Participant;
import com.falconSports.entity.Sports;
import com.falconSports.entity.Team;
import com.falconSports.exception.IdNotFoundException;
import com.falconSports.exception.ResourceNotFoundException;
import com.falconSports.repository.OrganizationRepository;
import com.falconSports.repository.ParticipantRepository;
import com.falconSports.repository.SportsRepository;
import com.falconSports.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	@Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SportsRepository sportsRepository;

	@Override
	public List<Team> getAllTeam() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(teamRepository.findAll().isEmpty())
		{
			throw new ResourceNotFoundException();
		}
		return teamRepository.findAll();
	}

	@Override
	public Team createTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	@Override
	public Team getTeamById(int teamId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if( teamRepository.findById(teamId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		Team team = teamRepository.findById(teamId).get();
		return team;
	}

	@Override
	public void deleteTeamById(int teamId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		if( teamRepository.findById(teamId).isEmpty())
		{
			throw new IdNotFoundException();
		}
		teamRepository.deleteById(teamId);
		
	}

	@Override
	public Team updateTeam(int teamId, Team team) {
		// TODO Auto-generated method stub
		team.setTeamId(teamId);
		return this.teamRepository.save(team);
	}

	@Override
	public List<Team> generateTeams() {
		List<Sports> sportsList = sportsRepository.findAll();
		List<Organization> organizationList = organizationRepository.findAll();
		List<Team> teams = new ArrayList<>();

		for (Organization organization : organizationList) {
		    for (Sports sport : sportsList) {
		        List<Participant> participants = participantRepository.findBySportsAndOrganization(sport, organization);
		        Collections.shuffle(participants);

		        int maxParticipants = sport.getMaxParticipants();
		        int participantsToAdd = Math.min(maxParticipants, participants.size());
		        List<Participant> selectedParticipants = participants.subList(0, participantsToAdd);

		        // Check if the number of selected participants is equal to maxParticipants
		        if (selectedParticipants.size() == maxParticipants) {
		            String baseTeamName = organization.getOrganizationName() + " " + sport.getSportsName() + " Team";
		            String teamName = baseTeamName;
		            int teamNumber = 1;

		            while (teamRepository.findByTeamName(teamName) != null) {
		                teamName = baseTeamName + " " + teamNumber;
		                teamNumber++;
		            }

		            Team team = new Team();
		            team.setTeamName(teamName);
		            team.setSports(sport);
		            team.setParticipant(selectedParticipants);
		            teams.add(team);
		        }
		    }
		}

		teams = teamRepository.saveAll(teams);
		return teams;
	}
		
}
