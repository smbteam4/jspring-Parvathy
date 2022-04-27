package com.saviour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saviour.model.DashboardModel;

@Service
public class ReportService {
	
	@Autowired
	private RobotService robotService;
	
	@Autowired
	private SurvivorService survivorService;
	
	public DashboardModel getDashBoard() {
		DashboardModel reportsBo=new DashboardModel();
		reportsBo.setRobotsReportBo(robotService.rebotReport());
		reportsBo.setSurvivorReportBo(survivorService.survivorDashBoard());
		return reportsBo;
	}

}
