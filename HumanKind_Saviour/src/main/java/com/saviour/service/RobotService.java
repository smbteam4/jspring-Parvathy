package com.saviour.service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saviour.model.Robot;
import com.saviour.model.RobotsDashBoardModel;

@Service
public class RobotService {
	
	public List<Robot> getRobotsList(){
		ObjectMapper mapper = new ObjectMapper();
        try {
        	Robot[] robots = mapper.readValue(new URL("https://robotstakeover20210903110417.azurewebsites.net/robotcpu"), Robot[].class);
            return Arrays.asList(robots);
        } catch (IOException e) {
            return Collections.emptyList();
        }
	}
	
	public RobotsDashBoardModel rebotReport(){
		List<Robot> robots=this.getRobotsList();
		
		if(!robots.isEmpty()) {
			RobotsDashBoardModel robotsDashBoardModel=new RobotsDashBoardModel();
			this.populateFlyingRobots(robotsDashBoardModel, robots);
			this.populateLandRobots(robotsDashBoardModel, robots);
			return robotsDashBoardModel;
		}
		return null;
	}
	
	public void populateFlyingRobots(RobotsDashBoardModel robotsDashBoardModel,
			List<Robot> robots) {
		robotsDashBoardModel.setFlyingRobots(robots
				.stream()
				.filter(r-> r.getCategory()
						.equalsIgnoreCase("Flying"))
				.collect(Collectors.toList()));
		robotsDashBoardModel.setlFlyRobotCounts(robotsDashBoardModel.getFlyingRobots().size());
	}
	
	public void populateLandRobots(RobotsDashBoardModel robotsDashBoardModel,
			List<Robot> robots) {
		robotsDashBoardModel.setLandRobots(robots
				.stream()
				.filter(r-> r.getCategory()
						.equalsIgnoreCase("Land"))
				.collect(Collectors.toList()));
		robotsDashBoardModel.setlLandRobotCounts(robotsDashBoardModel.getLandRobots().size());
	}

}
