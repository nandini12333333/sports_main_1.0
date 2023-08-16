package com.falconSports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

	Team findByTeamName(String teamName);

}
