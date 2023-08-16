package com.falconSports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.SportsCategory;

@Repository
public interface SportsCategoryRepository extends JpaRepository<SportsCategory,String> {
	

}
