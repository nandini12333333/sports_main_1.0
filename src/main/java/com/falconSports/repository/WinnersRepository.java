package com.falconSports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falconSports.entity.Winners;

@Repository
public interface WinnersRepository extends JpaRepository<Winners, Integer>{

	public Winners getByYear(int year);
}
