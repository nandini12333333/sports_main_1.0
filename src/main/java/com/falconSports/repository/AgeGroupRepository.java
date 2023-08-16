package com.falconSports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.AgeGroup;

@Repository
public interface AgeGroupRepository extends JpaRepository<AgeGroup, Integer> {

}
