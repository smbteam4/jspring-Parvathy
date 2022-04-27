package com.saviour.model;

public class SurvivorUpdateInput {
	private int  survivorId;
	
	private InfectionModel infectionModel;
	
	private LocationModel locationModel;

	

	public int getSurvivorId() {
		return survivorId;
	}

	public void setSurvivorId(int survivorId) {
		this.survivorId = survivorId;
	}

	public InfectionModel getInfectionModel() {
		return infectionModel;
	}

	public void setInfectionModel(InfectionModel infectionModel) {
		this.infectionModel = infectionModel;
	}

	public LocationModel getLocationModel() {
		return locationModel;
	}

	public void setLocationModel(LocationModel locationModel) {
		this.locationModel = locationModel;
	}
	
	

}
