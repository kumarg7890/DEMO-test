package com.example.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.example.dto.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	
	public String saveVehicle(Vehicle vehicle){
		
		return UUID.randomUUID().toString();
	}

}
