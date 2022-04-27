package com.saviour.model;

import java.util.List;


public class RobotsDashBoardModel {
	
	private long lFlyRobotCounts;
	private long lLandRobotCounts;
	private List<Robot> flyingRobots;
	private List<Robot> landRobots;
	public List<Robot> getFlyingRobots() {
		return flyingRobots;
	}
	public void setFlyingRobots(List<Robot> flyingRobots) {
		this.flyingRobots = flyingRobots;
	}
	public long getlFlyRobotCounts() {
		return lFlyRobotCounts;
	}
	public void setlFlyRobotCounts(long lFlyRobotCounts) {
		this.lFlyRobotCounts = lFlyRobotCounts;
	}
	public long getlLandRobotCounts() {
		return lLandRobotCounts;
	}
	public void setlLandRobotCounts(long lLandRobotCounts) {
		this.lLandRobotCounts = lLandRobotCounts;
	}
	public List<Robot> getLandRobots() {
		return landRobots;
	}
	public void setLandRobots(List<Robot> landRobots) {
		this.landRobots = landRobots;
	}
	
	
	

}
