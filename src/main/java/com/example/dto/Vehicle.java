package com.example.dto;

public class Vehicle {
	
	private String vin;
	private int year;
	private String make;
	private String model;
	private String transmissionType;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}
	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", transmissionType="
				+ transmissionType + "]";
	}
}