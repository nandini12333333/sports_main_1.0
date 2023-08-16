package com.falconSports.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Sports {
	
	@Id
	private int sportsId;
	
	private String sportsName;
	
	@OneToOne(targetEntity = SportsCategory.class)
	@JoinColumn(name= "categoryId", referencedColumnName= "categoryId")
	private SportsCategory sportsCategory;
	
	private String images;
	
	private int maxParticipants;
	
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}



	public int getSportsId() {
		return sportsId;
	}

	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public SportsCategory getSportsCategory() {
		return sportsCategory;
	}

	public void setSportsCategory(SportsCategory sportsCategory) {
		this.sportsCategory = sportsCategory;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public Sports(int sportsId, String sportsName, SportsCategory sportsCategory, int maxParticipants, String images) {
		super();
		this.sportsId = sportsId;
		this.sportsName = sportsName;
		this.sportsCategory = sportsCategory;
		this.maxParticipants = maxParticipants;
		this.images = images;
	}

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
