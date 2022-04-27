package com.saviour.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saviour.entity.Survivor;
import com.saviour.model.InfectionModel;
import com.saviour.model.SurvivorDashBoardModel;
import com.saviour.model.SurvivorUpdateInput;
import com.saviour.repository.SurvivorRepository;

@Service
public class SurvivorService {
	
	@Autowired
	private SurvivorRepository survivorRepository;
	
	public Survivor saveSurvivor(Survivor survivor) {
		
		
		return survivorRepository.save(survivor);
	}
	
	public Survivor updateSurvivor(SurvivorUpdateInput survivorUpdateInput) {
		
		Survivor survivor=survivorRepository
				.findById(survivorUpdateInput.getSurvivorId())
				.orElse(null);
		
		if(survivor!=null) {
			if(survivorUpdateInput.getInfectionModel()!=null) {
				
				survivor.setInfectedStatus(survivorUpdateInput
						.getInfectionModel()
						.isInfectedStatus());
				survivor.setInfectionStage(survivorUpdateInput
						.getInfectionModel()
						.getInfectionStage());
				

			}
			if(survivorUpdateInput.getLocationModel()!=null) {
				survivor.setLatitude(survivorUpdateInput
						.getLocationModel()
						.getLatitude());
				survivor.setLongitude(survivorUpdateInput
						.getLocationModel()
						.getLongitude());

			}
			return survivorRepository.save(survivor);
		}
		return null;
	}
	

	
	public SurvivorDashBoardModel survivorDashBoard(){
		List<Survivor> survivors=survivorRepository.findAll();
		
		if(!survivors.isEmpty()) {
			SurvivorDashBoardModel survivorDashBoardModel=new SurvivorDashBoardModel();
			survivorDashBoardModel.setInfectedList(survivors
					.stream()
					.filter(Survivor::isInfectedStatus)
					.collect(Collectors.toList()));
			survivorDashBoardModel.setNonInfectedList(survivors
					.stream()
					.filter(s-> !s.isInfectedStatus())
					.collect(Collectors.toList()));
			survivorDashBoardModel.setTotalCount(survivors.size());
			survivorDashBoardModel.setInfectedCount(survivorDashBoardModel.getInfectedList().size());
			survivorDashBoardModel.setNonInfectedCount(survivorDashBoardModel.getNonInfectedList().size());
			
			
			survivorDashBoardModel.setInfectedPercentage(
					percentage(survivorDashBoardModel.getInfectedCount(),
							survivorDashBoardModel.getTotalCount()));
			survivorDashBoardModel.setNonInfectedPercentage(
					percentage(survivorDashBoardModel.getNonInfectedCount(),
							survivorDashBoardModel.getTotalCount()));
			return survivorDashBoardModel;
		}
		return null;
	}
	
	 public double percentage(double obtained, double total) {
	        return obtained * 100 / total;
	    }

}
