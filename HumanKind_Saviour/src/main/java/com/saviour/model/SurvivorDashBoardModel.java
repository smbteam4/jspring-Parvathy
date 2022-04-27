package com.saviour.model;

import java.util.List;

import com.saviour.entity.Survivor;

public class SurvivorDashBoardModel {
	
	private List<Survivor> infectedList;
	private List<Survivor> nonInfectedList;
	private long totalCount;
	private long infectedCount;
	private long nonInfectedCount;
	private double infectedPercentage;
	private double nonInfectedPercentage;
	


	public List<Survivor> getInfectedList() {
		return infectedList;
	}
	public void setInfectedList(List<Survivor> infectedList) {
		this.infectedList = infectedList;
	}
	public List<Survivor> getNonInfectedList() {
		return nonInfectedList;
	}
	public void setNonInfectedList(List<Survivor> nonInfectedList) {
		this.nonInfectedList = nonInfectedList;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getInfectedCount() {
		return infectedCount;
	}
	public void setInfectedCount(long infectedCount) {
		this.infectedCount = infectedCount;
	}
	public long getNonInfectedCount() {
		return nonInfectedCount;
	}
	public void setNonInfectedCount(long nonInfectedCount) {
		this.nonInfectedCount = nonInfectedCount;
	}
	public double getInfectedPercentage() {
		return infectedPercentage;
	}
	public void setInfectedPercentage(double infectedPercentage) {
		this.infectedPercentage = infectedPercentage;
	}
	public double getNonInfectedPercentage() {
		return nonInfectedPercentage;
	}
	public void setNonInfectedPercentage(double nonInfectedPercentage) {
		this.nonInfectedPercentage = nonInfectedPercentage;
	}

	
	

}
