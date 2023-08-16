package com.falconSports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.Sports;
import com.falconSports.entity.SportsCategory;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Integer> {
	
	public List<Sports> findBySportsCategory(SportsCategory sportsCategory);

}
