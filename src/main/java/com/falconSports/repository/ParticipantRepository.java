package com.falconSports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.Organization;
import com.falconSports.entity.Participant;
import com.falconSports.entity.Sports;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {

	List<Participant> findBySportsAndOrganization(Sports sports, Organization organization);

	List<Participant> findBySports(Sports sport);

}
