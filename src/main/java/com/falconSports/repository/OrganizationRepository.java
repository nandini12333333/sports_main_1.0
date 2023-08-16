package com.falconSports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {

}
