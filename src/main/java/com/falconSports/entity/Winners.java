package com.falconSports.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Winners {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String winner;
	private String image;
	private int year;
	private String totalGames;
	private int points;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTotalGames() {
		return totalGames;
	}
	public void setTotalGames(String totalGames) {
		this.totalGames = totalGames;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Winners() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Winners(int id, String winner, String image, int year, String totalGames, int points) {
		super();
		this.id = id;
		this.winner = winner;
		this.image = image;
		this.year = year;
		this.totalGames = totalGames;
		this.points = points;
	}
	
	
	
	
	

}
