package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ReturnDetail;
import com.example.dto.Vehicle;
import com.example.exception.InvalidPayloadException;
import com.example.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/vehicle-api/v1/vehicles/vehicle")
	public ResponseEntity<ReturnDetail> createVehicle(@RequestBody Vehicle vehicle) throws Exception {

		boolean isValidPayload = validatePayload(vehicle);

		if (isValidPayload) {

			String UUID = vehicleService.saveVehicle(vehicle);
			
			return new ResponseEntity<>(new ReturnDetail().setCode(200).setMessage("Success").setDetail(UUID), HttpStatus.OK);

		} else {

			throw new Exception("Something Went wrong, Please try again");
		}

	}

	private boolean validatePayload(Vehicle vehicle) throws InvalidPayloadException {

		if (null != vehicle) {

			String transmissionType = vehicle.getTransmissionType();

			if (null == transmissionType) {
				
				throw new InvalidPayloadException("Transmission Type is Mandatory");
			} 
			
			if(!(transmissionType.equals("AUTO") || transmissionType.equals("MANUAL"))) {

				throw new InvalidPayloadException("MANUAL/AUTO Transmission Type Allowed");
			}
			
			return true;
			
		} else {
			
			throw new InvalidPayloadException("No Payload Defined");

		}
	}
}
