package com.saviour.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="survivor")
public class Survivor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int age;
	
	private String gender;
	
	private String latitude;
	
	private String longitude;
	
	@Column(name="infected_status")
	private boolean infectedStatus;
	
	@Column(name="infection_stage")
	private int infectionStage;
	

	
	@ManyToMany
	@JoinTable(
			name="survivor_resource",
			joinColumns=@JoinColumn(name="survivor_id"),
			inverseJoinColumns = @JoinColumn(name="resource_id")
			)
	private List<Resources> resources;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public boolean isInfectedStatus() {
		return infectedStatus;
	}

	public void setInfectedStatus(boolean infectedStatus) {
		this.infectedStatus = infectedStatus;
	}

	public int getInfectionStage() {
		return infectionStage;
	}

	public void setInfectionStage(int infectionStage) {
		this.infectionStage = infectionStage;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}
	


}
