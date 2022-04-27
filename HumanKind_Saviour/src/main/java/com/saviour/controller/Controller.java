package com.saviour.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saviour.entity.Resources;
import com.saviour.entity.Survivor;
import com.saviour.model.DashboardModel;
import com.saviour.model.Robot;
import com.saviour.model.SurvivorUpdateInput;
import com.saviour.repository.ResourceRepository;
import com.saviour.model.InfectionModel;
import com.saviour.service.ReportService;
import com.saviour.service.RobotService;
import com.saviour.service.SurvivorService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private RobotService robotService;
	
	@Autowired
	private SurvivorService survivorService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	

	
	@GetMapping("/resources")
	public ResponseEntity<List<Resources>> getResources() {
		
		return new ResponseEntity<>(resourceRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/survivor")
	public ResponseEntity<Survivor> saveSurvivor(@RequestBody Survivor survivor) {
		
		return new ResponseEntity<>(survivorService.saveSurvivor(survivor), HttpStatus.OK);
	}
	
	@PutMapping("/survivor")
	public ResponseEntity<Survivor> registerSurvivor(@RequestBody SurvivorUpdateInput survivorUpdateInput) {
		
		return new ResponseEntity<>(survivorService.updateSurvivor(survivorUpdateInput), HttpStatus.OK);
	}
	

	
	@GetMapping("/dashboard")
	public ResponseEntity<DashboardModel> getDashBoard() {
		return new ResponseEntity<>(reportService.getDashBoard(), HttpStatus.OK);
	}

}
